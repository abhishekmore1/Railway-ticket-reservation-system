package com.example.booking.service.service;

import com.example.booking.service.entity.Bookings;
import com.example.booking.service.entity.Trains;

import java.util.List;

public interface BookingService {
    void addBooking(Bookings bookings, Long trainId);

    void deleteTicket(Long pnrNo);

    List<Bookings> getTicket(String email);

    List<Bookings> getAllBooking();


}
