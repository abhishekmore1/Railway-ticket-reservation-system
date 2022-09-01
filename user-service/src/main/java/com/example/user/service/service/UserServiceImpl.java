package com.example.user.service.service;

import com.example.user.service.entity.Bookings;
import com.example.user.service.entity.RegisterUser;
import com.example.user.service.entity.Trains;
import com.example.user.service.repository.TrainRepository;
import com.example.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public RegisterUser addUser(RegisterUser addUser) {

//        User user=new User();
//        user.setUsername(addUser.getUserName());
//        user.setPassword(addUser.getUserPassword());
//        user.isActive();
//        user.setRole("ROLE_USER");
//        userLoginRepository.save(user);
        return userRepository.save(addUser);
    }

    @Override
    public RegisterUser updateUser(Long userId, RegisterUser user) {
        RegisterUser newUser= userRepository.findById(userId).get();
        newUser.setUserName(user.getUserName());
        newUser.setUserEmail(user.getUserEmail());
        newUser.setUserPassword(user.getUserPassword());
        newUser.setUserPhoneNo(user.getUserPhoneNo());
        return userRepository.save(newUser);
    }

    @Override
    public RegisterUser getUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public List<RegisterUser> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<Object> getAllTrain() {
        Object[] train= restTemplate.getForObject("http://train-service:8081/train/getAllTrain", Object[].class);
        return Arrays.asList(train);
    }

    @Override
    public Trains getTrain(Long trainId) {
        Trains train=restTemplate.getForObject("http://train-service:8081/train/getTrain/"+trainId,Trains.class);
        return train;
//        return trainRepository.findById(trainId).get();
    }

    @Override
    public String addBooking(Bookings bookings, Long trainId) {
        return restTemplate.postForObject("http://booking-service:8084/booking/bookTicket/"+trainId,bookings,String.class);
    }

    @Override
    public List<Object> getTicket(String email) {
        Object[] myBookings= restTemplate.getForObject("http://booking-service:8084/booking/viewTicket/"+email, Object[].class);
        return Arrays.asList(myBookings);
    }

    @Override
    public Trains addTrain(Trains train) {
        return trainRepository.save(train);
    }

    @Override
    public List<Object> getTrainByFromStationToStation(String from, String to) {
        Object[] train=restTemplate.getForObject("http://train-service:8081/train/"+from+"/and/"+to,Object[].class);
        return Arrays.asList(train);
//        return searchRepository.findByFromStationAndToStation(from,to);
    }

    @Override
    public void deleteTicket(Long pnrNo) {
        restTemplate.delete("http://booking-service:8084/booking/cancelTicket/"+pnrNo,Bookings.class);
    }


}
