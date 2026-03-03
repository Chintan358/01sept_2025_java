

package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByIsActiveTrue();
}
