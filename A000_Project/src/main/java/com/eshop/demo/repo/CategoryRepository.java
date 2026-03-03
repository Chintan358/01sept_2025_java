

package com.eshop.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.demo.model.Category;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
