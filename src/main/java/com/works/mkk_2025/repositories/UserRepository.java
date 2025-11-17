package com.works.mkk_2025.repositories;

import com.works.mkk_2025.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Customer, Long> {
}