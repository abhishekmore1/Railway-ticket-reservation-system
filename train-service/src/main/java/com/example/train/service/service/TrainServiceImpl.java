package com.example.train.service.service;

import com.example.train.service.entity.Trains;
import com.example.train.service.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainRepository trainRepository;

    //Admin can add trains
    @Override
    public Trains addTrain(Trains train) {
        return trainRepository.save(train);
    }

    //Admin passenger can view all the trains
    @Override
    public List<Trains> getAllTrain() {
        return trainRepository.findAll();
    }

    //Admin passenger can view all the available trains
    @Override
    public Trains getTrain(Long trainId) {
        return trainRepository.findById(trainId).get();
    }

    @Override
    public Trains updateTrain(Long trainId, Trains train) {
        Trains newTrain=trainRepository.findById(trainId).get();
        newTrain.setTrainName(train.getTrainName());
        newTrain.setFromStation(train.getFromStation());
        newTrain.setToStation(train.getToStation());
        newTrain.setTime(train.getTime());
        newTrain.setDate(train.getDate());
        newTrain.setTicketFare(train.getTicketFare());
        return trainRepository.save(newTrain);
    }

    //To get the trains form source and destination
    @Override
    public List<Trains> getTrainByFromStationToStation(String from, String to) {
        return trainRepository.findByFromStationAndToStation(from,to);

    }

    //Admin can delete the trains
    @Override
    public void deleteTrain(Long trainId) {
        trainRepository.deleteById(trainId);
    }
}
