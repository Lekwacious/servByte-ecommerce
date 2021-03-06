package com.ecommerce.servbyte.data.repository;

import com.ecommerce.servbyte.data.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE :n")
    List<Product> findByName(@Param("n") String name);
}
