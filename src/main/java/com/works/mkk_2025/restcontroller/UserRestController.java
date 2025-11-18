package com.works.mkk_2025.restcontroller;

import com.works.mkk_2025.entities.Customer;
import com.works.mkk_2025.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserRestController {

    final UserService userService;
    private final Map<String, UserService> map;

    @PostMapping("login")
    public Customer login(@RequestBody Customer customer) {
        return userService.login(customer);
    }

    @PostMapping("save")
    public Customer save(@RequestBody Customer customer) {
        return userService.addUser(customer);
    }


    @GetMapping("list")
    public List<Customer> list() {
        return userService.getAllUser();
    }


    @GetMapping("listx")
    public List<Customer> listx() {
        return userService.getAllUserx();
    }

    /*
    @GetMapping("/get")
    public String get() {
        map.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println(map.size());
        return userService.textChange();
    }


    @GetMapping("/getData")
    public String get(@RequestParam String name) {
        return userService.textChange(name);
    }
     */

}
