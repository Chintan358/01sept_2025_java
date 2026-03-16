

package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Order;
import com.eshop.demo.model.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
