package com.example.booking.service.service;

import com.example.booking.service.entity.Bookings;
import com.example.booking.service.entity.Trains;
import com.example.booking.service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private RestTemplate restTemplate;

    public void addBooking(Bookings booking, Long trainId){
        Trains train=restTemplate.getForObject("http://train-service:8081/train/getTrain/"+trainId,Trains.class);
        booking.setTrainId(trainId);
        booking.setSource(train.getFromStation());
        booking.setDestination(train.getToStation());
        booking.setTotalPrice((double) (booking.getNoOfTickets()*train.getTicketFare()));

        bookingRepository.save(booking);
        simpleMailSender(booking,train);
    }

    @Override
    public void deleteTicket(Long pnrNo) {
        bookingRepository.deleteById(pnrNo);
    }

    @Override
    public List<Bookings> getTicket(String email) {
        return bookingRepository.findByPassengerEmail(email);

    }

    @Override
    public List<Bookings> getAllBooking() {
        return bookingRepository.findAll();
    }

    public void simpleMailSender(Bookings bookings,Trains trains) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("dhaaneshwarsw@gmail.com");
        message.setTo("dhaaneshwar@gmail.com");
        message.setText("PNR No: "+bookings.getPnrNo()+"\nName: "+bookings.getPassengerName()+"\nTrain name: "+trains.getTrainName()+
                "\nPhone No: "+bookings.getPassengerPhNo()+"\nEmail: "+bookings.getPassengerEmail()+"\nSource: "+trains.getFromStation()+
                "\nDestination: "+trains.getFromStation()+"\nTotal no of tickets: "+bookings.getNoOfTickets()+"\nTotalPrice: "+(double) (bookings.getNoOfTickets()*trains.getTicketFare()));
        message.setSubject("Ticket confirmation");

        mailSender.send(message);
        System.out.println("Mail send...");
    }

}
