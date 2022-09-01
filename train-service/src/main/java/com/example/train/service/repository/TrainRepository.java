package com.example.train.service.repository;

import com.example.train.service.entity.Trains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Trains,Long> {
    List<Trains> findByFromStationAndToStation(String from, String to);

    List<Trains> findByTrainName(String abc);

    void deleteByTrainName(String s);

    boolean existsByTrainName(String aaa);
}
