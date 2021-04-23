package com.ecommerce.servbyte.data.repository;

import com.ecommerce.servbyte.data.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
