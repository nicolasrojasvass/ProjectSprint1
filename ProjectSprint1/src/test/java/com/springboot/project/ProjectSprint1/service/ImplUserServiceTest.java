package com.springboot.project.ProjectSprint1.service;

import com.springboot.project.ProjectSprint1.model.User;
import com.springboot.project.ProjectSprint1.repository.IUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ImplUserServiceTest {

    @Mock
    private IUserRepository iUserRepository;

    @InjectMocks
    ImplUserService userService;

    private User user;

    @BeforeEach
    void setUp(){
        System.out.println("Inicio Test");
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setIdUser(10L);
        user.setLast_name("Nicolas");
        user.setLast_name("Rojas");
        user.setEmail("nicolas.rojas@vasslatam.com");
        user.setUsername("nicolas.rojas");
        user.setPassword("123456789");
    }

    @Test
    void createUser() {
    }

    @Test
    void findByIdUser() {
        when(userService.findByIdUser(String.valueOf(user.getIdUser())));
    }

    @Test
    void getAllUsers() {
        when(userService.getAllUsers());
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void findByUsername() {
    }

    @Test
    void findByUsernameAndPassword() {
    }

    @AfterEach
    void tearDown(){
        System.out.println("Fin Test");
    }
}