package com.learn.initiative.store.repository;


import com.learn.initiative.store.model.dto.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
