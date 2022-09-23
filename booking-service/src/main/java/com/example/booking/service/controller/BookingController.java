package com.example.booking.service.controller;

import com.example.booking.service.entity.Bookings;
import com.example.booking.service.repository.BookingRepository;
import com.example.booking.service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/")
    public String hello(){
        return "From booking service";
    }

    @PostMapping("/bookTicket/{trainId}")
    public String addBooking(@RequestBody Bookings bookings,@PathVariable("trainId") Long trainId){
        bookingService.addBooking(bookings,trainId);
        return "Booking successful";
    }

//    @GetMapping("/viewTicket/{pnr}")
//    public Bookings getTicket(@PathVariable("pnr") Long email ) {
//        return bookingRepository.findByPnrNo(email);
//    }

    @GetMapping("/viewTicket/{email}")
    public List<Bookings> getTicket(@PathVariable("email") String email ) {
        return bookingService.getTicket(email);
    }

    @GetMapping("/viewAllTicket")
    public List<Bookings> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @DeleteMapping("/cancelTicket/{pnrNo}")
    public String deleteTicket(@PathVariable("pnrNo") Long pnrNo){
        bookingService.deleteTicket(pnrNo);
        return "Ticket cancellation successful";
    }

}
