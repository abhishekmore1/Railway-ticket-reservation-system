package com.example.admin.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.admin.service.entity.Trains;
import com.example.admin.service.repository.TrainRepository;
import com.example.admin.service.repository.BookingRepository;
import com.example.admin.service.entity.Bookings;

import com.example.admin.service.controller.AdminController;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.Optional;

@SpringBootTest
class AdminServiceApplicationTests {

	@Autowired
	private TrainRepository trainRepository;

	// Testing get All trains

	@Test
	@DisplayName("GetAllTrain")
	void getAllTrain() {
		List<Trains> train = trainRepository.findAll();
		assertNotNull(train);
	}

	// Testing get all booking

	@Test
	@DisplayName("viewAllBooking")
	void viewAllBooking() {

		List<Trains> booking = trainRepository.findAll();
		assertNotNull(booking);
	}

	@Test
	@DisplayName("GetTrainByLocation")
	void getTrainByLocation() {
		Trains train = new Trains();
		train.setTrainId(15L);
		train.setTrainName("aaa");
		train.setFromStation("xxx");
		train.setToStation("yyy");
		train.setTicketFare(100L);
		train.setDate("13/12/2022");
		train.setTime("15:30");
		List<Trains> train2 = trainRepository.findByFromStationAndToStation("xxx", "yyy");
		assertNotNull(train2.get(0));
	}

	// Testing adding new train

	@Test
	@DisplayName("AddTrain")
	void addTrain() {
		Trains train = new Trains();
		train.setTrainName("aaa");
		train.setFromStation("xxx");
		train.setToStation("yyy");
		train.setTicketFare(100L);
		train.setDate("13/12/2022");
		train.setTime("15:30");
		trainRepository.save(train);
		assertNotNull(trainRepository.findByTrainName("aaa"));
	}
	
	

	@Test
	@DisplayName("GetTrain")
	void getTrain() {
		Trains train = trainRepository.findById(1L).get();
		assertAll(() -> assertEquals("MumbaiExpress", train.getTrainName()),
				() -> assertEquals("Mumbai", train.getFromStation()),
				() -> assertEquals("Pune", train.getToStation()),
				() -> assertEquals(100, train.getTicketFare()),
				() -> assertEquals("27/08/2022", train.getDate()),
				() -> assertEquals("13:45", train.getTime())

		);
	}

}