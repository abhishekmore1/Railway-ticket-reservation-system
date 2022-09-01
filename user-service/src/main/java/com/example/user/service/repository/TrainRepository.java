package com.example.user.service.repository;

import com.example.user.service.entity.Trains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Trains,Long> {

}
