package com.codegym.thi.service;

import com.codegym.thi.model.Motel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMotelService {
    List<Motel> findAll();

    void save(Motel motel);

    Motel findById(int id);

    void deleteById(int id);

    Page<Motel> paqing(Pageable pageable);

    Page<Motel> search(String name, String paymentId, Pageable pageable);


}
