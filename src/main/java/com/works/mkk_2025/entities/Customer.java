package com.works.mkk_2025.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer uid;
    private String name;
    private String surname;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Address> address;

}
