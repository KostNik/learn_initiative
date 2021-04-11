package com.learn.initiative.store.repository;

import com.learn.initiative.store.model.dto.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CategoriesRepository extends PagingAndSortingRepository<Category, Long> {

    Optional<Category> findCategoryByName(String name);

}
