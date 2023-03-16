package com.codegym.phonemanage.service;

import com.codegym.phonemanage.model.Smartphone;
import com.codegym.phonemanage.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    ISmartphoneRepository iSmartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return iSmartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return iSmartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return iSmartphoneRepository.save(smartPhone);
    }

    @Override
    public void deleteById(Long id) {
        iSmartphoneRepository.deleteById(id);
    }
}
