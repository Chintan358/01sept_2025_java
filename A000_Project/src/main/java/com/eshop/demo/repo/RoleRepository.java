

package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
