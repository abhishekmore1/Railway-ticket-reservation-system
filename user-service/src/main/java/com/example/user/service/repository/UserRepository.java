package com.example.user.service.repository;

import com.example.user.service.entity.MyUserDetails;
import com.example.user.service.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<RegisterUser,Long> {

    List<RegisterUser> findByUserName(String abc);

    RegisterUser findByUserEmail(String userName);
}
