package com.example.train.service.controller;

import com.example.train.service.service.TrainService;
import com.example.train.service.entity.Trains;
import com.example.train.service.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;
    @Autowired
    private TrainRepository trainRepository;

    @GetMapping("/")
    public String hello(){
        return "From train service";
    }

    //Admin to add train
    @PostMapping("/addTrain")
    public Trains addTrain(@RequestBody Trains train){
        return trainService.addTrain(train);
    }

    //Admin passenger can view the details of the train
    @GetMapping("/getTrain/{trainId}")
    public Trains getTrain(@PathVariable("trainId") Long trainId){
        return trainService.getTrain(trainId);
    }

//    @PutMapping("/updateTrain/{trainId}")
//    public Trains updateTrain(@PathVariable("trainId") Long trainId,@RequestBody Trains train){
//        return trainService.updateTrain(trainId,train);
//    }

    //To get trains from source and destination
    @GetMapping("/{from}/and/{to}")
    public List<Trains> getTrainByLocation(@PathVariable("from") String from, @PathVariable("to") String to){
        return trainService.getTrainByFromStationToStation(from,to);
//        List<Trains> s = trainRepository.findAll();
//        for(Trains d: s)
//        {
//            if(d.getFromStation().equals(from) && d.getToStation().equals(to) )
//            {
//                return d;
//            }
//        }
//        return null;
    }

    //To view all the available trains
    @GetMapping("/getAllTrain")
    public List<Trains> getAllTrain(){
        return trainService.getAllTrain();
    }

    //Admin can delete the trains
    @DeleteMapping("/deleteTrain/{trainId}")
    public String deleteTrain(@PathVariable("trainId") Long trainId){
        trainService.deleteTrain(trainId);
        return "Train is deleted successfully";
    }


}
