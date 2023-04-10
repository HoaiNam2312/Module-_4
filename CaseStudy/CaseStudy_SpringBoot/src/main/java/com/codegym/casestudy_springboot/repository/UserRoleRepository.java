package com.codegym.casestudy_springboot.repository;

import com.codegym.casestudy_springboot.model.user.AppUser;
import com.codegym.casestudy_springboot.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
