package com.springboot.project.ProjectSprint1.repository;

import com.springboot.project.ProjectSprint1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

    List<User> findByUsernameAndPassword(String username, String password);
}
