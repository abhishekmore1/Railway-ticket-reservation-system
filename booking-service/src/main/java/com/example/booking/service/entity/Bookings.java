package com.example.booking.service.entity;

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
    private String trainName;
    private String passengerName;
    private String passengerPhNo;
    private String passengerEmail;
    private String source;
    private String destination;
    private Long noOfTickets;
    private Double totalPrice;
	public void setTrainId(long l) {
		// TODO Auto-generated method stub
		
	}
	public Long getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(Long pnrNo) {
		this.pnrNo = pnrNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerPhNo() {
		return passengerPhNo;
	}
	public void setPassengerPhNo(String passengerPhNo) {
		this.passengerPhNo = passengerPhNo;
	}
	public String getPassengerEmail() {
		return passengerEmail;
	}
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Long getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(Long noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
