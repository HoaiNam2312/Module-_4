package com.codegym.casestudy_springboot.service.imp;

import com.codegym.casestudy_springboot.model.employee.EducationDegree;
import com.codegym.casestudy_springboot.repository.IEducationDegreeRepository;
import com.codegym.casestudy_springboot.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll() ;
    }
}
