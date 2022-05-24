package com.springboot.project.ProjectSprint1.controller;


import com.springboot.project.ProjectSprint1.controller.dto.UserDTO;
import com.springboot.project.ProjectSprint1.model.User;
import com.springboot.project.ProjectSprint1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    IUserService iUserService;

    @PutMapping("/createUser")
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

    @DeleteMapping("/deleteUser/{idUser}")
    public boolean deleteUser(@PathVariable String idUser) {
        return iUserService.deleteUser(idUser);
    }

    @PostMapping("/updateUser/{idUser}")
    public Optional<User> updateUser(@PathVariable String idUser, @RequestBody UserDTO userDTO) {
        return iUserService.updateUser(idUser, new User(userDTO));
    }
}
