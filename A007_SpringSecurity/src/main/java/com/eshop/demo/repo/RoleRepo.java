package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
