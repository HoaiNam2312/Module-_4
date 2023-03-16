package com.codegym.phonemanage.repository;

import com.codegym.phonemanage.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long> {
}
