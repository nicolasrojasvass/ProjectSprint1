package com.springboot.project.ProjectSprint1.controller;


import com.springboot.project.ProjectSprint1.controller.dto.BookDTO;
import com.springboot.project.ProjectSprint1.model.Book;
import com.springboot.project.ProjectSprint1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    @Autowired
    IBookService iBookService;

    @PostMapping("/createBook")
    public Book createBook(@RequestBody BookDTO bookDTO){
        return iBookService.createBook(new Book(bookDTO));
    }

    @GetMapping("/findById/{idBook}")
    public Optional<Book> findById(@PathVariable String idBook){
        return iBookService.findByIdBook(idBook);
    }

    @GetMapping("/getAllBooks")
    public Optional<List<Book>> getAllBooks(){
        return iBookService.getAllBooks();
    }

    @DeleteMapping("/deleteBook/{idBook}")
    public boolean deleteBook(@PathVariable String idBook){
        return iBookService.deleteBook(idBook);
    }

    @PostMapping("/updateBook/{idBook}")
    public Optional<Book> updateBook(@PathVariable String idBook, @RequestBody BookDTO bookDTO){
        return Optional.empty();
    }



}
