package com.codegym.libraryapp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;

    @OneToMany(mappedBy = "book")
    private Set<Reader> readerSet;

    public Book() {
    }

    public Book(int id, String name, int quantity, Set<Reader> readerSet) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.readerSet = readerSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Reader> getReaderSet() {
        return readerSet;
    }

    public void setReaderSet(Set<Reader> readerSet) {
        this.readerSet = readerSet;
    }
}
