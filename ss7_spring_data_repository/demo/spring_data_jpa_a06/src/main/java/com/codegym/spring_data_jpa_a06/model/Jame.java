package com.codegym.spring_data_jpa_a06.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Jame {
    @Id
    private String username;
    private String password;

    @OneToOne(mappedBy = "jame")
    private Student student;
}
