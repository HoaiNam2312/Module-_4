package com.codegym.casestudy_springboot.repository;

import com.codegym.casestudy_springboot.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositiontRepository extends JpaRepository<Position,Integer> {
}
