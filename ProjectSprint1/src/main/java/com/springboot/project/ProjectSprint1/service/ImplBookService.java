package com.springboot.project.ProjectSprint1.service;

import com.springboot.project.ProjectSprint1.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class ImplBookService implements IBookService {

    private final List<Book> listBooks = new ArrayList<>();

    @Override
    public Book createBook(Book book) {
        listBooks.add(book);
        return listBooks.stream().filter(x -> x.getIdBook().equals(book.getIdBook())).collect(Collectors.toList()).get(0);
    }

    @Override
    public Optional<Book> findByIdBook(String idBook) {
        Book book = listBooks.stream().filter(x -> x.getIdBook().equals(idBook)).collect(Collectors.toList()).get(0);
        return book != null ? Optional.of(book) : Optional.empty();
    }

    @Override
    public Optional<List<Book>> getAllBooks() {
        return listBooks != null && !listBooks.isEmpty() ? Optional.of(listBooks) : Optional.empty();
    }

    @Override
    public boolean deleteBook(String idBook) {
        listBooks.removeIf(x -> x.getIdBook().equals(idBook));
        return false;
    }

    @Override
    public Optional<Book> updateBook(String idBook, Book book) {
        return Optional.empty();
    }
}
