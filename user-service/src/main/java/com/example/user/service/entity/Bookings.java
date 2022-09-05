package com.example.user.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bookings {

    @Id
    @SequenceGenerator(
            name="booking_sequence",
            sequenceName="booking_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="booking_sequence"
    )
    private Long pnrNo;
    private Long trainName;
    private String passengerName;
    private String passengerPhNo;
    private String passengerEmail;
    private String source;
    private String destination;
    private Long noOfTickets;
    private Double totalPrice;
}