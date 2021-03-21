package com.learn.initiative.store.repository;

import com.learn.initiative.store.model.dto.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
}
