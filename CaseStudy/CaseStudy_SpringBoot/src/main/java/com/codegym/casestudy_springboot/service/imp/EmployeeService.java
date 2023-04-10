package com.codegym.casestudy_springboot.service.imp;

import com.codegym.casestudy_springboot.model.customer.Customer;
import com.codegym.casestudy_springboot.model.employee.Employee;
import com.codegym.casestudy_springboot.repository.IEmployeeRepository;
import com.codegym.casestudy_springboot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;


    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> paging(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> search(String idCard, String divisionId, String positionId, String educationDegree, Pageable pageable) {
        return iEmployeeRepository.search(idCard,divisionId,positionId,educationDegree,pageable);
    }
//    @Override
//    public Page<Employee> search(String idCard, Pageable pageable) {
//        return iEmployeeRepository.search(idCard,pageable);
//    }
}
