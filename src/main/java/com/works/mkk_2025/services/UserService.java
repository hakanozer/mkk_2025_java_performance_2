package com.works.mkk_2025.services;

import com.works.mkk_2025.entities.Customer;
import com.works.mkk_2025.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    String name = "mkk";
    private final HttpServletRequest req;


    public Customer login(Customer customer) {
        Optional<Customer> optionalCustomer = userRepository.findByEmailEqualsIgnoreCaseAndPasswordEquals(customer.getEmail(), customer.getPassword());
        if (optionalCustomer.isPresent()) {
            System.out.println("login success");
            req.getSession().setAttribute("user", optionalCustomer.get());
            return optionalCustomer.get();
        }
        return null;
    }


    @CacheEvict(value = "users", allEntries = true)
    public Customer addUser(Customer customer) {
        Object o = req.getSession().getAttribute("user");
        if (o != null) {
            userRepository.save(customer);
            return customer;
        }
        return null;
    }


    @Cacheable("users")
    public List<Customer> getAllUser() {
        Object o = req.getSession().getAttribute("user");
        if (o != null) {
            return userRepository.findAll();
        }
        return null;
    }

    public List<Customer> getAllUserx() {
        Object o = req.getSession().getAttribute("user");
        if (o != null) {
            return userRepository.findAll();
        }
        return null;
    }

    @Async("taskExecutor")
    public String textChange() {
        req.getSession().setAttribute("name", "ali@mail.com");
        return name;
    }

    public String textChange(String name) {
        this.name = name;
        String surname = "";
        System.gc();
        surname = null;
        return name;
    }

}
