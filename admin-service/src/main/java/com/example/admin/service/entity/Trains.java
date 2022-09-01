package com.example.admin.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trains {

    @Id
    @SequenceGenerator(
            name="train_sequence",
            sequenceName="train_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="train_sequence"
    )
    private Long trainId;
    private String trainName;
    private String fromStation;
    private String toStation;
    private Long ticketFare;
    private String date;
    private String time;

}
