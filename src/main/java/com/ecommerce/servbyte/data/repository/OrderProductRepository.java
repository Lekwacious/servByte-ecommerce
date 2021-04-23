package com.ecommerce.servbyte.data.repository;

import com.ecommerce.servbyte.data.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
