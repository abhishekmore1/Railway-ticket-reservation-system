package com.example.admin.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RegisterUser {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userPhoneNo;
}
