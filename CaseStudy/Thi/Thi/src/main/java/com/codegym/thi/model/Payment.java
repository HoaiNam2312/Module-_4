package com.codegym.thi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "payment")
    private Set<Motel> motelSet;

    public Payment() {
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

    public Set<Motel> getMotelSet() {
        return motelSet;
    }

    public void setMotelSet(Set<Motel> motelSet) {
        this.motelSet = motelSet;
    }
}

