package com.example.search.service.service;

import com.example.search.service.entity.Trains;

import java.util.List;

public interface SearchService {
    List<Object> getTrainByFromStationToStation(String from, String to);
}
