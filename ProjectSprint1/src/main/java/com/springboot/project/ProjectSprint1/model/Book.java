package com.springboot.project.ProjectSprint1.model;

import com.springboot.project.ProjectSprint1.controller.dto.BookDTO;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long idBook;
    private String nombre;
    private String autor;

    public Book(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    public Book(){}

    public Book(BookDTO bookDTO){
        this(bookDTO.getNombre(),bookDTO.getAutor());
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
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
