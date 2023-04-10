package com.codegym.thi.repository;

import com.codegym.thi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

}
