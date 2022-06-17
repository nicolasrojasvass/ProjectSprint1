package com.springboot.project.ProjectSprint1.service;

import com.springboot.project.ProjectSprint1.model.Book;
import com.springboot.project.ProjectSprint1.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImplBookService implements IBookService {

    private final IBookRepository iBookRepository;

    public ImplBookService(@Autowired IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
    }

    @Override
    public Book createBook(Book book) {
        return iBookRepository.save(book);
    }

    @Override
    public Optional<Book> findByIdBook(Long idBook) {
        try {
            return iBookRepository.findById(idBook);
        } catch (NumberFormatException e) {
            e.getMessage();
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Book>> getAllBooks() {
        List<Book> listBooks = iBookRepository.findAll();
        return (!listBooks.isEmpty()) ? Optional.of(listBooks) : Optional.empty();
    }

    @Override
    public boolean deleteBook(Long idBook) {
        try {
            iBookRepository.deleteById(idBook);
            Optional<Book> book = iBookRepository.findById(idBook);
            return !book.isPresent();
        } catch (NumberFormatException e) {
            e.getMessage();
            return false;
        }
    }

    @Override
    public Optional<Book> updateBook(String idBook, Book bookUpdated) {
        Optional<Book> book = iBookRepository.findById(Long.parseLong(idBook));
        if (book.isPresent()){
            book.get().setNombre(bookUpdated.getNombre());
            book.get().setAutor(bookUpdated.getAutor());
            return Optional.of(iBookRepository.save(book.get()));
        } else {
            return Optional.empty();
        }
    }
}
