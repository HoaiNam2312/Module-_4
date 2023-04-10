package com.codegym.casestudy_springboot.service;

import com.codegym.casestudy_springboot.model.employee.Division;
import com.codegym.casestudy_springboot.model.employee.Position;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();
}
