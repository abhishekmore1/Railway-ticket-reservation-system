package com.example.admin.service.controller;

import com.example.admin.service.entity.AuthenticationRequest;
import com.example.admin.service.entity.AuthenticationResponse;
import com.example.admin.service.entity.Trains;
import com.example.admin.service.repository.UserRepository;
import com.example.admin.service.service.AdminService;
import com.example.admin.service.service.MyUserDetailService;
import com.example.admin.service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;
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
    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String getAdmin(){
        return "From admin-service";
    }

    //   To add train

    @PostMapping("/addTrain")
    public String addTrain(@RequestBody Trains train){
        adminService.addTrain(train);
        return "Train is added successfully";
    }

//    To delete train

    @DeleteMapping("/deleteTrain/{trainId}")
    public String deleteTrain(@PathVariable("trainId") Long trainId){
        adminService.deleteTrain(trainId);
        return "train deletion is successful";
    }

//    To see train details

    @GetMapping("/getTrain/{trainId}")
    public Trains getTrain(@PathVariable("trainId") Long trainId){
        return adminService.getTrain(trainId);
    }

//    To see all the available trains

    @GetMapping("/getAllTrain")
    public List<Object> getAllTrain(){
        return adminService.getAllTrain();
    }

    //To get trains from source and destination

    @GetMapping("/{from}/and/{to}")
    public List<Object> getTrainByLocation(@PathVariable("from") String from, @PathVariable("to") String to){
        return adminService.getTrainByFromStationToStation(from,to);
    }

//    To view All the Booking

    @GetMapping("/viewAllBooking")
    public List<Object> getAllBooking(){
        return adminService.getAllBooking();
    }

//    To cancel the booking

    @DeleteMapping("/cancelTicket/{pnrNo}")
    public String deleteTicket(@PathVariable("pnrNo") Long pnrNo){
        adminService.deleteTicket(pnrNo);
        return "Ticket cancellation successful";
    }
}
