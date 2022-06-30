package com.springboot.project.ProjectSprint1.service;

import com.springboot.project.ProjectSprint1.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    Book createBook(Book book);

    Optional<Book> findByIdBook(Long idBook);

    Optional<List<Book>> getAllBooks();

    boolean deleteBook(Long idBook);

    Optional<Book> updateBook(String idBook, Book book);

}
