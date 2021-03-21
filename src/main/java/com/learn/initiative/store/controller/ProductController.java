package com.learn.initiative.store.controller;

import com.learn.initiative.store.model.dto.Product;
import com.learn.initiative.store.repository.ProductsRepository;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductsRepository productsRepository;

    @GetMapping("/all")
    @ApiOperation("Get all products")
    public Iterable<Product> allProducts() {
        return productsRepository.findAll();
    }

}
