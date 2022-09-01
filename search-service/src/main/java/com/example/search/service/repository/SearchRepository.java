package com.example.search.service.repository;

import com.example.search.service.entity.Trains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<Trains,Long> {
    Trains findByFromStationAndToStation(String from, String to);
}
