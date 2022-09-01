package com.example.admin.service.repository;

import com.example.admin.service.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {
    Bookings getByPassengerEmail(String email);
}