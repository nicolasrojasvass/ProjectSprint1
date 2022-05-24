package com.springboot.project.ProjectSprint1.service;

import com.springboot.project.ProjectSprint1.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User createUser(User user);

    Optional<User> findByIdUser(String idUser);

    Optional<List<User>> getAllUsers();

    boolean deleteUser(String idUser);

    Optional<User> updateUser(String idUser, User user);
}
