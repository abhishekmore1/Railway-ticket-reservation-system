package com.example.train.service;

import com.example.train.service.entity.Trains;
import com.example.train.service.repository.TrainRepository;
import com.example.train.service.service.TrainServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {ServiceMockitoTest.class})
public class ServiceMockitoTest {

    @Mock
    TrainRepository trainRepository;
    @InjectMocks
    TrainServiceImpl trainService;

    @Test
    @DisplayName("DeleteTrain")
    void deleteTrain() {
        Trains train=new Trains();
        train.setTrainId(15L);
        train.setTrainName("aaa");
        train.setFromStation("xxx");
        train.setToStation("yyy");
        train.setTicketFare(100L);
        train.setDate("13/12/2022");
        train.setTime("15:30");
        trainService.deleteTrain(15L);
        verify(trainRepository,times(1)).deleteById(15L);

    }

}
