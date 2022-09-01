package com.example.search.service.controller;

import com.example.search.service.entity.Trains;
import com.example.search.service.service.SearchService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/")
    public String hello(){
        return "From search controller";
    }

    //Get trains from user source to destination
    @GetMapping("/{from}/and/{to}")
    public List<Object> getTrainByLocation(@PathVariable("from") String from, @PathVariable("to") String to){
        return searchService.getTrainByFromStationToStation(from,to);
    }


}
