
package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Address;
import com.eshop.demo.model.User;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
	List<Address> findByUser(User user);
}
