package com.example.validating_form_input.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {

    private int id;

    @NotBlank
    @Size(min = 2,max = 30)
    private String name;

    @Min(18)
    private int age;

    public UserDto(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserDto() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
