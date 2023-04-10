package com.codegym.thi.service;

import com.codegym.thi.model.Payment;

import java.util.List;

public interface IPaymentService {
    List<Payment> findAll();
}
