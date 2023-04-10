package com.codegym.thi.service.imp;

import com.codegym.thi.model.Motel;
import com.codegym.thi.repository.IMotelRepository;
import com.codegym.thi.service.IMotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotelService implements IMotelService {
    @Autowired
    IMotelRepository iMotelRepository;

    @Override
    public List<Motel> findAll() {
        return iMotelRepository.findAll();
    }

    @Override
    public void save(Motel motel) {
        iMotelRepository.save(motel);
    }

    @Override
    public Motel findById(int id) {
        return iMotelRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        iMotelRepository.deleteById(id);
    }

    @Override
    public Page<Motel> paqing(Pageable pageable) {
        return iMotelRepository.findAll(pageable);
    }

    @Override
    public Page<Motel> search(String name, String paymentId, Pageable pageable) {
        return iMotelRepository.search(name,paymentId,pageable);
    }
}
