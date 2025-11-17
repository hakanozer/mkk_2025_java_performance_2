package com.works.mkk_2025.restcontroller;

import com.works.mkk_2025.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {

    final UserService userService;
    private final Map<String, UserService> map;

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



}
