package com.example.user.service;

import com.example.user.service.entity.RegisterUser;
import com.example.user.service.repository.UserRepository;
import static org.junit.jupiter.api.Assertions.*;
import com.example.user.service.service.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {ServiceMockitoTest.class})
@TestComponent
public class ServiceMockitoTest {

    //repository class is used to mock
    @Mock
    UserRepository userRepository;

    //country service is used to invoke the method that are available in the controller
    @InjectMocks
    UserServiceImpl userService;

    //Testing the get all user
    @Test
    @DisplayName("GetAllUser1")
    void getAllUser_Test1() {
        List<RegisterUser> users=new ArrayList<RegisterUser>();
        users.add(new RegisterUser(1L,"gokul","gokul@gmail.com","gokul123","987654321"));
        users.add(new RegisterUser(2L,"arul","arul@gmail.com","arul123","987654321"));

        when(userRepository.findAll()).thenReturn(users);
        assertEquals(2,userService.getAllUser().size());
    }

    @Test
    @DisplayName("GetAllUser2")
    void getAllUser_Test2() {
        List<RegisterUser> users=new ArrayList<RegisterUser>();
        users.add(new RegisterUser(1L,"Kavin","kavin@gmail.com","kavin123","987654321"));
        users.add(new RegisterUser(2L,"Jagan","Jagan@gmail.com","jagan123","987654321"));

        when(userRepository.findAll()).thenReturn(users);
        assertEquals(2,userService.getAllUser().size());
    }

    @Test
    @DisplayName("GetAllUser3")
    void getAllUser_Test3() {
        List<RegisterUser> users=new ArrayList<RegisterUser>();
        users.add(new RegisterUser(1L,"jai","jai@gmail.com","jai123","987654321"));
        users.add(new RegisterUser(2L,"jagadesh","jagadees@gmail.com","jagadees123","987654321"));

        when(userRepository.findAll()).thenReturn(users);
        assertEquals(2,userService.getAllUser().size());
    }

    @Test
    @DisplayName("GetAllUser4")
    void getAllUser_Test4() {
        List<RegisterUser> users=new ArrayList<RegisterUser>();
        users.add(new RegisterUser(1L,"sai","sai@gmail.com","sai123","987654321"));
        users.add(new RegisterUser(2L,"vicky","vicky@gmail.com","vicky123","987654321"));

        when(userRepository.findAll()).thenReturn(users);
        assertEquals(2,userService.getAllUser().size());
    }

    //Testing the get user
    @Test
    @DisplayName("GetUser1")
    void getUser_Test1() {
        List<RegisterUser> users=new ArrayList<RegisterUser>();
        users.add(new RegisterUser(1L,"amir","amir@gmail.com","amir123","987654321"));
        users.add(new RegisterUser(2L,"raju","raju@gmail.com","raju123","987654321"));

        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(users.get(0)));
        assertEquals(1L,userService.getUser(1L).getUserId());
    }

    @Test
    @DisplayName("GetUser2")
    void getUser_Test2() {
        List<RegisterUser> users=new ArrayList<RegisterUser>();
        users.add(new RegisterUser(1L,"amir","amir@gmail.com","amir123","987654321"));
        users.add(new RegisterUser(2L,"raju","raju@gmail.com","raju123","987654321"));

        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(users.get(0)));
        assertEquals(1L,userService.getUser(1L).getUserId());
    }

    @Test
    @DisplayName("GetUser3")
    void getUser_Test3() {
        List<RegisterUser> users=new ArrayList<RegisterUser>();
        users.add(new RegisterUser(1L,"amir","amir@gmail.com","amir123","987654321"));
        users.add(new RegisterUser(2L,"raju","raju@gmail.com","raju123","987654321"));

        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(users.get(0)));
        assertEquals(1L,userService.getUser(1L).getUserId());
    }

    @Test
    @DisplayName("GetUser4")
    void getUser_Test4() {
        List<RegisterUser> users=new ArrayList<RegisterUser>();
        users.add(new RegisterUser(1L,"amir","amir@gmail.com","amir123","987654321"));
        users.add(new RegisterUser(2L,"raju","raju@gmail.com","raju123","987654321"));

        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(users.get(0)));
        assertEquals(1L,userService.getUser(1L).getUserId());
    }

    //Testing the add User
    @Test
    @DisplayName("AddUser1")
    void addUser_Test1() {
        RegisterUser user=new RegisterUser();
        user.setUserId(1L);
        user.setUserName("aaa");
        user.setUserEmail("aaa@gmail.com");
        user.setUserPassword("aaa");
        user.setUserPhoneNo("987654321");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.addUser(user));
    }
    @Test
    @DisplayName("AddUser2")
    void addUser_Test2() {
        RegisterUser user=new RegisterUser();
        user.setUserId(2L);
        user.setUserName("bbb");
        user.setUserEmail("bbb@gmail.com");
        user.setUserPassword("bbb");
        user.setUserPhoneNo("987654321");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.addUser(user));
    }
    @Test
    @DisplayName("AddUser3")
    void addUser_Test3() {
        RegisterUser user=new RegisterUser();
        user.setUserId(3L);
        user.setUserName("ccc");
        user.setUserEmail("ccc@gmail.com");
        user.setUserPassword("ccc");
        user.setUserPhoneNo("987654321");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.addUser(user));
    }
    @Test
    @DisplayName("AddUser4")
    void addUser_Test4() {
        RegisterUser user=new RegisterUser();
        user.setUserId(3L);
        user.setUserName("ddd");
        user.setUserEmail("ddd@gmail.com");
        user.setUserPassword("ddd");
        user.setUserPhoneNo("987654321");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.addUser(user));
    }


    //Testing the user updation
    @Test
    @DisplayName("UpdateUser1")
    void updateUser_Test1() {
        RegisterUser user=new RegisterUser();
        user.setUserId(3L);
        user.setUserName("cba");
        user.setUserEmail("abc@gmail.com");
        user.setUserPassword("cba");
        user.setUserPhoneNo("987654321");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.addUser(user));
    }

    @Test
    @DisplayName("UpdateUser2")
    void updateUser_Test2() {
        RegisterUser user=new RegisterUser();
        user.setUserId(3L);
        user.setUserName("cba");
        user.setUserEmail("abc@gmail.com");
        user.setUserPassword("cba");
        user.setUserPhoneNo("987654321");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.addUser(user));
    }

    @Test
    @DisplayName("UpdateUser3")
    void updateUser_Test3() {
        RegisterUser user=new RegisterUser();
        user.setUserId(3L);
        user.setUserName("cba");
        user.setUserEmail("abc@gmail.com");
        user.setUserPassword("cba");
        user.setUserPhoneNo("987654321");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.addUser(user));
    }

    @Test
    @DisplayName("UpdateUser4")
    void updateUser_Test4() {
        RegisterUser user=new RegisterUser();
        user.setUserId(3L);
        user.setUserName("cba");
        user.setUserEmail("abc@gmail.com");
        user.setUserPassword("cba");
        user.setUserPhoneNo("987654321");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.addUser(user));
    }
}
