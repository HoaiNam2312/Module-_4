package com.codegym.casestudy_springboot.service.imp;

import com.codegym.casestudy_springboot.model.employee.Division;
import com.codegym.casestudy_springboot.repository.IDivisionRepository;
import com.codegym.casestudy_springboot.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepository iDivisionRepository;
    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
