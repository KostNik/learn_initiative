package com.learn.initiative.store.model.dto;

import lombok.Data;

@Data
//@Entity
//@Table(name = "products")
public class Product {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

}
