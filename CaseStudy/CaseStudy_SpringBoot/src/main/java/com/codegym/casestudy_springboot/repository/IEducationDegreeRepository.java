package com.codegym.casestudy_springboot.repository;

import com.codegym.casestudy_springboot.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Integer> {
}
