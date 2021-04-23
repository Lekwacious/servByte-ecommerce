package com.ecommerce.servbyte.data.repository;

import com.ecommerce.servbyte.data.models.City;
import com.ecommerce.servbyte.data.models.Product;
import com.ecommerce.servbyte.data.models.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceProviderRepository  extends JpaRepository<ServiceProvider, Long> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE :n")
    List<ServiceProvider> findByCity(@Param("n") City city);
}
