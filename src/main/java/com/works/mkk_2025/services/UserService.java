package com.works.mkk_2025.services;

import com.works.mkk_2025.entities.Customer;
import com.works.mkk_2025.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    String name = "mkk";

    @Async
    public String textChange() {
        Random ran = new Random();
        String data = "a";
        String data1 = new String("a");
        System.out.println(data.hashCode());
        System.out.println(data1.hashCode());
        System.out.println(ran.hashCode());
        if(data.equals(data1)) {

        }
        if (data == data1) {

        }

        Customer u1 = new Customer();
        u1.setUid(1);
        u1.setName("ali");
        u1.setSurname("bil");
        userRepository.save(u1);

        Customer u2 = new Customer();
        u2.setUid(1);
        u2.setName("ali");
        u2.setSurname("bil");

        if (u1.equals(u2)) {
            System.out.println("equals");
        }else {
            System.out.println("not equals");
        }

        List<Customer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            Customer user = new Customer();
            user.setUid(i);
            user.setName("ali");
            user.setSurname("bil");
            list.add(user);
        }
        System.out.println(list.size());

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
