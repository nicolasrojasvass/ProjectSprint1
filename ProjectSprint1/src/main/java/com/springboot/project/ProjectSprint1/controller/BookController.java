package com.springboot.project.ProjectSprint1.controller;


import com.springboot.project.ProjectSprint1.controller.dto.BookDTO;
import com.springboot.project.ProjectSprint1.model.Book;
import com.springboot.project.ProjectSprint1.service.IBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    private final IBookService iBookService;

    public BookController(IBookService iBookService) {
        this.iBookService = iBookService;
    }


    @PostMapping("/createBook")
    public Book createBook(@RequestBody BookDTO bookDTO){
        return iBookService.createBook(new Book(bookDTO));
    }

    @GetMapping("/{idBook}")
    public Optional<Book> findById(@PathVariable Long idBook){
        return iBookService.findByIdBook(idBook);
    }

    @GetMapping("")
    public Optional<List<Book>> getAllBooks(){
        return iBookService.getAllBooks();
    }

    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable Long id){
        return iBookService.deleteBook(id);
    }

    @PutMapping("/{idBook}")
    public Optional<Book> updateBook(@PathVariable String idBook, @RequestBody BookDTO bookDTO){
        return iBookService.updateBook(idBook, new Book(bookDTO));
    }



}
