package com.codegym.smartphone_manager.repository;

import com.codegym.smartphone_manager.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long> {
}
