package com.example.train.service;

import com.example.train.service.entity.Trains;
import com.example.train.service.repository.TrainRepository;
import com.example.train.service.service.TrainService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class TrainServiceApplicationTests {

	@Autowired
	private TrainRepository trainRepository;
	@Autowired
	private TrainService trainService;

	//Testing adding new train
	@Test
	@DisplayName("AddTrain")
	void addTrain() {
		Trains train=new Trains();
		train.setTrainName("aaa");
		train.setFromStation("xxx");
		train.setToStation("yyy");
		train.setTicketFare(100L);
		train.setDate("13/12/2022");
		train.setTime("15:30");
		trainRepository.save(train);
		assertNotNull(trainRepository.findByTrainName("aaa"));
	}

	//Testing get train by from and to location
	@Test
	@DisplayName("GetTrainByLocation")
	void getTrainByLocation() {
		Trains train=new Trains();
		train.setTrainId(15L);
		train.setTrainName("aaa");
		train.setFromStation("xxx");
		train.setToStation("yyy");
		train.setTicketFare(100L);
		train.setDate("13/12/2022");
		train.setTime("15:30");
		List<Trains> train2=trainRepository.findByFromStationAndToStation("xxx","yyy");
		assertEquals(train,train2.get(0));
	}

	//Testing get train
	@Test
	@DisplayName("GetTrain")
	void getTrain() {
		Trains train=trainRepository.findById(3L).get();
		assertAll(
				()->assertEquals("BangloreExpress",train.getTrainName()),
				()->assertEquals("Banglore",train.getFromStation()),
				()->assertEquals("Pune",train.getToStation()),
				()->assertEquals(200,train.getTicketFare()),
				()->assertEquals("29/08/2022",train.getDate()),
				()->assertEquals("12:00",train.getTime())

		);
	}

	//Testing get All trains
	@Test
	@DisplayName("GetAllTrain")
	void getAllTrain() {
		List<Trains> train=trainRepository.findAll();
		assertNotNull(train);
	}

	//Testing delete train
	@Test
	@DisplayName("DeleteTrain")
	void deleteTrain() {
		trainRepository.deleteByTrainName("xyz");
		assertFalse(trainRepository.existsByTrainName("xyz"));
	}


}
