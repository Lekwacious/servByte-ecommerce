package com.ecommerce.servbyte.data.repository;

import com.ecommerce.servbyte.data.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
