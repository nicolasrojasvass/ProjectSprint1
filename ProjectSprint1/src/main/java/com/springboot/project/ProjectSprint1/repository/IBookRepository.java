package com.springboot.project.ProjectSprint1.repository;

import com.springboot.project.ProjectSprint1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {

}
