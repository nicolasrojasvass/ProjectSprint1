package com.springboot.project.ProjectSprint1.service;

import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.springboot.project.ProjectSprint1.model.Book;
import com.springboot.project.ProjectSprint1.repository.IBookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class ImplBookServiceTest {

    ImplBookService implBookService;

    @Test
    void createBook() {
        IBookRepository iBookRepository = Mockito.mock(IBookRepository.class);
        implBookService =  new ImplBookService(iBookRepository);
        Book book = new Book();
        implBookService.createBook(book);
        verify(iBookRepository).save(book);
    }

    @Test
    void findByIdBook() {
        Long id  = 1L;
        IBookRepository iBookRepository = Mockito.mock(IBookRepository.class);
        implBookService =  new ImplBookService(iBookRepository);
        implBookService.findByIdBook(id);
        verify(iBookRepository).findById(id);
    }

    @Test
    void getAllBooks() {
        IBookRepository iBookRepository = Mockito.mock(IBookRepository.class);
        implBookService =  new ImplBookService(iBookRepository);
        implBookService.getAllBooks();
        verify(iBookRepository).findAll();
    }

    @Test
    void deleteBook() {
        Long id  = 1L;
        IBookRepository iBookRepository = Mockito.mock(IBookRepository.class);
        implBookService =  new ImplBookService(iBookRepository);
        implBookService.deleteBook(id);
        verify(iBookRepository).deleteById(id);
    }
    /*
    @Test
    void updateBook() {
        Book book = new Book();
        IBookRepository iBookRepository = Mockito.mock(IBookRepository.class);
        implBookService =  new ImplBookService(iBookRepository);
        implBookService.updateBook("1", book);
        verify(iBookRepository).save(book);
    }*/
}