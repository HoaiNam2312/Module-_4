package com.codegym.casestudy_springboot.service.imp;

import com.codegym.casestudy_springboot.model.employee.Position;
import com.codegym.casestudy_springboot.repository.IPositiontRepository;
import com.codegym.casestudy_springboot.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositiontRepository iPositiontRepository;
    @Override
    public List<Position> findAll() {
        return iPositiontRepository.findAll();
    }
}
