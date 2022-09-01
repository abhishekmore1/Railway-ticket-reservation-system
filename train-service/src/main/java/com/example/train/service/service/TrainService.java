package com.example.train.service.service;

import com.example.train.service.entity.Trains;

import java.util.List;

public interface TrainService {
    Trains addTrain(Trains train);

    List<Trains> getAllTrain();

    Trains getTrain(Long trainId);

    Trains updateTrain(Long trainId, Trains train);

    void deleteTrain(Long trainId);

    List<Trains> getTrainByFromStationToStation(String from, String to);
}
