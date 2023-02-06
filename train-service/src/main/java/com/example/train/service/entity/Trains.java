package com.example.train.service.entity;

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
            strategy =GenerationType.SEQUENCE,
            generator="train_sequence"
    )
    private Long trainId;
    private String trainName;
    private String fromStation;
    private String toStation;
    private Long ticketFare;
    private String date;
    private String time;
	public Long getTrainId() {
		return trainId;
	}
	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getFromStation() {
		return fromStation;
	}
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	public String getToStation() {
		return toStation;
	}
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	public Long getTicketFare() {
		return ticketFare;
	}
	public void setTicketFare(Long ticketFare) {
		this.ticketFare = ticketFare;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
