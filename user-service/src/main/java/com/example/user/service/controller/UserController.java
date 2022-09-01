package com.example.user.service.controller;

import com.example.user.service.entity.*;
import com.example.user.service.repository.TrainRepository;
import com.example.user.service.repository.UserRepository;
import com.example.user.service.service.MyUserDetailService;
import com.example.user.service.service.UserService;
import com.example.user.service.util.JwtUtil;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        String username=authenticationRequest.getUsername();
        String password=authenticationRequest.getPassword();

        try
        {
            //using authentication manager in order to authenticate using username and password
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }
        catch(BadCredentialsException e)
        {
            throw new Exception("Incorrect username and password",e);
//            return ResponseEntity.ok("Incorrect username and password");
        }
        //if authenticated create jwt token

        //call userDetailService loaduserbyusername => authenticated username get instance to userDetails and pass to generateToken
        final UserDetails userDetails=userDetailService.loadUserByUsername(authenticationRequest.getUsername());
        //jwtTokenUtil needs userDetails in order to create jwt
        final String jwt=jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping("/")
    public String hello(){
        return "From user service";
    }

    //New user registration as add user
    @PostMapping("/userRegistration")
    public RegisterUser addUser(@RequestBody RegisterUser user){
        return userService.addUser(user);
    }


    @GetMapping("/getUser/{userId}")
    public RegisterUser getUser(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }

    @GetMapping("/getAllUser")
    public List<RegisterUser> getAllUser(){
        return userService.getAllUser();
    }

    //User can update his/her details
    @PutMapping("/updateUser/{userId}")
    public RegisterUser updateUser(@PathVariable("userId") Long userId,@RequestBody RegisterUser user){
        return userService.updateUser(userId,user);
    }

//    @PostMapping("/addTrain")
//    public Trains addTrain(@RequestBody Trains train){
//        return userService.addTrain(train);
//    }

    //admin and passengers can view the train details
    @GetMapping("/getTrain/{trainId}")
    public Trains getTrain(@PathVariable("trainId") Long trainId){
        return userService.getTrain(trainId);
    }

    //user and passenger can view all the trains
    @GetMapping("/getAllTrain")
    public List<Object> getAllTrain(){
        return userService.getAllTrain();
    }

    @PostMapping("/bookTicket/{trainId}")
    public Bookings addBooking(@RequestBody Bookings bookings, @PathVariable("trainId") Long trainId){
        return userService.addBooking(bookings,trainId);
    }

    @GetMapping("/viewTicket/{email}")
    public List<Object> getTicket(@PathVariable("email") String email ) {
        return userService.getTicket(email);
    }

    @DeleteMapping("/cancelTicket/{pnrNo}")
    public String deleteTicket(@PathVariable("pnrNo") Long pnrNo){
        userService.deleteTicket(pnrNo);
        return "Ticket cancellation successful";
    }

    @GetMapping("/{from}/and/{to}")
    public List<Object> getTrainByLocation(@PathVariable("from") String from, @PathVariable("to") String to){
        return userService.getTrainByFromStationToStation(from,to);
    }

}
