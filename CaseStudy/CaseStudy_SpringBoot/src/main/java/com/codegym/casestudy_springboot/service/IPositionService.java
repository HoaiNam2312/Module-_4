package com.codegym.casestudy_springboot.service;

import com.codegym.casestudy_springboot.model.customer.CustomerType;
import com.codegym.casestudy_springboot.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();

}
