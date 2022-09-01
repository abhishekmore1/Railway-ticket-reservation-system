package com.example.user.service.service;

import com.example.user.service.entity.Bookings;
import com.example.user.service.entity.RegisterUser;
import com.example.user.service.entity.Trains;

import java.util.List;

public interface UserService {
    public RegisterUser addUser(RegisterUser user);

    RegisterUser updateUser(Long userId, RegisterUser user);

    RegisterUser getUser(Long userId);

    Trains addTrain(Trains train);

    List<RegisterUser> getAllUser();

    List<Object> getAllTrain();

    Trains getTrain(Long trainId);

    String addBooking(Bookings bookings, Long trainId);

    List<Object> getTicket(String email);

    List<Object> getTrainByFromStationToStation(String from, String to);

    void deleteTicket(Long pnrNo);
}
