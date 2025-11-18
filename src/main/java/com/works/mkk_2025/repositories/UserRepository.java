package com.works.mkk_2025.repositories;

import com.works.mkk_2025.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Customer, Long> {


    @Query("""
            select c from Customer c inner join c.address address
            where upper(address.title) like upper(concat('%', ?1, '%'))""")
    List<Customer> allFind(String title);

    List<Customer> findByAddress_AidEquals(Long aid);

}