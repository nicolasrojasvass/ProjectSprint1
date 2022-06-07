package com.springboot.project.ProjectSprint1.controller;


import com.springboot.project.ProjectSprint1.controller.dto.UserDTO;
import com.springboot.project.ProjectSprint1.model.User;
import com.springboot.project.ProjectSprint1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2/users")
public class UserController {
    @Autowired
    IUserService iUserService;

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(iUserService.createUser(new User(userDTO)), HttpStatus.OK);
    }

    @GetMapping("/findById/{idUser}")
    public ResponseEntity<Optional<User>> findById(@PathVariable String idUser) {
        return new ResponseEntity<>(iUserService.findByIdUser(idUser), HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Optional<List<User>>> getAllUsers() {
        return new ResponseEntity<>(iUserService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{idUser}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String idUser) {
        return new ResponseEntity<>(iUserService.deleteUser(idUser), HttpStatus.OK);
    }

    @PutMapping("/updateUser/{idUser}")
    public ResponseEntity<Optional<User>> updateUser(@PathVariable String idUser, @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(iUserService.updateUser(idUser, new User(userDTO)), HttpStatus.OK);
    }
}
