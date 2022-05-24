package com.springboot.project.ProjectSprint1.model;

import com.springboot.project.ProjectSprint1.controller.dto.BookDTO;

import java.util.UUID;

public class Book {

    private String idBook;
    private String nombre;
    private String autor;

    public Book(String nombre, String autor) {
        this.idBook = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.autor = autor;
    }

    public Book(BookDTO bookDTO){
        this(bookDTO.getNombre(),bookDTO.getAutor());
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook='" + idBook + '\'' +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
