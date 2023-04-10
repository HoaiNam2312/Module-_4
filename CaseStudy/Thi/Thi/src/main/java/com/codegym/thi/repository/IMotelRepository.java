package com.codegym.thi.repository;

import com.codegym.thi.model.Motel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMotelRepository extends JpaRepository<Motel, Integer> {
    Page<Motel> findAll(Pageable pageable);

    @Query(value = "select * from motel where name like  %:name% and payment_id like %:paymentId%", nativeQuery = true)
    Page<Motel> search(@Param("name") String name,
                          @Param("paymentId") String paymentId,
                          org.springframework.data.domain.Pageable pageable);

//    Page<Motel> deleteMotelsById(Pageable pageable);
}
