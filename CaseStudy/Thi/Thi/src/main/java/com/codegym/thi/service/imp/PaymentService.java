package com.codegym.thi.service.imp;

import com.codegym.thi.model.Payment;
import com.codegym.thi.repository.IPaymentRepository;
import com.codegym.thi.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    IPaymentRepository iPaymentRepository;

    @Override
    public List<Payment> findAll() {
        return iPaymentRepository.findAll();
    }
}
