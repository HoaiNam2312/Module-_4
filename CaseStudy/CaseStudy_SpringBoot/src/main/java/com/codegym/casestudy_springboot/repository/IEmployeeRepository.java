package com.codegym.casestudy_springboot.repository;

import com.codegym.casestudy_springboot.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAll(Pageable pageable);

    @Query(value = "select * from employee where id_card like  :idCard and division_id like :divisionId  and position_id like :positionId and education_degree_id like :educationDegree", nativeQuery = true)
    Page<Employee> search(@Param("idCard") String idCard,
                          @Param("divisionId") String divisionId,
                          @Param("positionId") String positionId,
                          @Param("educationDegree") String educationDegree,
                          Pageable pageable);
}
