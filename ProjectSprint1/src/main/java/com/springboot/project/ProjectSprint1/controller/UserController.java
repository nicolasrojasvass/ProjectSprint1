package com.springboot.project.ProjectSprint1.controller;

import com.springboot.project.ProjectSprint1.controller.dto.UserDTO;
import com.springboot.project.ProjectSprint1.model.User;
import com.springboot.project.ProjectSprint1.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody UserDTO userDTO) {
        return iUserService.createUser(new User(userDTO));
    }

    @GetMapping("/findById/{idUser}")
    public Optional<User> findById(@PathVariable String idUser) {
        return iUserService.findByIdUser(idUser);
    }

    @GetMapping("/getAllUsers")
    public Optional<List<User>> getAllUsers() {
        return iUserService.getAllUsers();
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@PathVariable String idUser) {
        return iUserService.deleteUser(idUser);
    }

    @DeleteMapping("/deleteUser")
    public Optional<User> updateUser(@PathVariable String idUser, @RequestBody UserDTO userDTO) {
        return iUserService.updateUser(idUser, new User(userDTO));
    }
}
