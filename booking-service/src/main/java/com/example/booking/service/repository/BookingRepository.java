package com.example.booking.service.repository;

import com.example.booking.service.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {
    Bookings getByPassengerEmail(String email);

    List<Bookings> findByPassengerEmail(String email);
}
