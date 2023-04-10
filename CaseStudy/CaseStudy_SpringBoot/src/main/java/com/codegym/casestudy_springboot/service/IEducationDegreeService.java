package com.codegym.casestudy_springboot.service;

import com.codegym.casestudy_springboot.model.employee.EducationDegree;
import com.codegym.casestudy_springboot.model.employee.Position;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();

}
