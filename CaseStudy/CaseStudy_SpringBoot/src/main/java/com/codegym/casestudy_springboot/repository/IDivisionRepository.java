package com.codegym.casestudy_springboot.repository;

import com.codegym.casestudy_springboot.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division,Integer> {
}
