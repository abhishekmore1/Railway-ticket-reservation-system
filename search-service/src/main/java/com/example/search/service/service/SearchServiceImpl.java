package com.example.search.service.service;

import com.example.search.service.entity.Trains;
import com.example.search.service.repository.SearchRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private RestTemplate restTemplate;

    //Get trains from user source to destination
    @Override
    public List<Object> getTrainByFromStationToStation(String from, String to) {
        Object[] train=restTemplate.getForObject("http://train-service:8081/train/"+from+"/and/"+to,Object[].class);
        return Arrays.asList(train);
//        return searchRepository.findByFromStationAndToStation(from,to);
    }
}
