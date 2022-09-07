package com.example.user.service.entity;

public class AuthenticationResponse {
    private final String jwt;
    private RegisterUser registerUser;

    public AuthenticationResponse(String jwt, RegisterUser registerUser) {
        this.jwt = jwt;
        this.registerUser = registerUser;
    }

    public RegisterUser getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

//    public AuthenticationResponse(String jwt) {
//        this.jwt = jwt;
//    }

    public String getJwt(){
        return jwt;
    }
}