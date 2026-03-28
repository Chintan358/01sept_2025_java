

package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Role;
import com.eshop.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   
	Optional<User> findByEmail(String email);
	Optional<User> findByName(String name);
    boolean existsByEmail(String email);
    
    public List<User> findByRole(Role role);
}
