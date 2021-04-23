package com.ecommerce.servbyte.data.repository;

import com.ecommerce.servbyte.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
    Boolean existsByEmail(String email);
}
