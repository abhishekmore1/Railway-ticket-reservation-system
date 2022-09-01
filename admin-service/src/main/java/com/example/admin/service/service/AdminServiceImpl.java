package com.example.admin.service.service;

import com.example.admin.service.entity.Bookings;
import com.example.admin.service.entity.Trains;
import com.example.admin.service.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private RestTemplate restTemplate;

//    To  get all the available trains

    @Override
    public List<Object> getAllTrain() {
        Object[] train= restTemplate.getForObject("http://train-service:8081/train/getAllTrain", Object[].class);
        return Arrays.asList(train);
    }

//    To see all the bookings

    @Override
    public List<Object> getAllBooking() {
        Object[] booking= restTemplate.getForObject("http://booking-service:8084/booking/viewAllTicket", Object[].class);
        return Arrays.asList(booking);
    }

//    To get train details

    @Override
    public Trains getTrain(Long trainId) {
        Trains train=restTemplate.getForObject("http://train-service:8081/train/getTrain/"+trainId,Trains.class);
        return train;
    }

//    To add new train

    @Override
    public Trains addTrain(Trains train) {
        return trainRepository.save(train);
    }

//    To delete the train

    @Override
    public void deleteTrain(Long trainId) {
        restTemplate.delete("http://train-service:8081/train/deleteTrain/"+trainId,Trains.class);
    }

//To get the trains form source and destination

    @Override
    public List<Object> getTrainByFromStationToStation(String from, String to) {
        Object[] train=restTemplate.getForObject("http://train-service:8081/train/"+from+"/and/"+to,Object[].class);
        return Arrays.asList(train);
//        return searchRepository.findByFromStationAndToStation(from,to);
    }

//    To delete the bookings

    @Override
    public void deleteTicket(Long pnrNo) {
        restTemplate.delete("http://booking-service:8084/booking/cancelTicket/"+pnrNo, Bookings.class);

    }
}
