package com.example.admin.service.service;

import com.example.admin.service.entity.Trains;

import java.util.List;

public interface AdminService {
    Trains addTrain(Trains train);

    List<Object> getAllTrain();

    Trains getTrain(Long trainId);

    void deleteTrain(Long trainId);

    List<Object> getAllBooking();

    void deleteTicket(Long pnrNo);

    List<Object> getTrainByFromStationToStation(String from, String to);
}
