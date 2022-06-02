package com.springboot.project.ProjectSprint1.repository;

import com.springboot.project.ProjectSprint1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
