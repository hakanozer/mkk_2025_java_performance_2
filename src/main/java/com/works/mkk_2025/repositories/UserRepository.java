package com.works.mkk_2025.repositories;

import com.works.mkk_2025.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmailEqualsIgnoreCaseAndPasswordEquals(String email, String password);
}