package com.learn.initiative.store.service;

import com.learn.initiative.store.model.dto.Category;
import com.learn.initiative.store.model.dto.Product;
import com.learn.initiative.store.repository.CategoriesRepository;
import com.learn.initiative.store.repository.ProductsRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.SetUtils;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CategoryService {

    private final ProductsRepository productsRepository;
    private final CategoriesRepository categoriesRepository;

    @Caching(
            put = {
                    @CachePut(value = "categories", keyGenerator = "cacheKeyGenerator"),
                    @CachePut(value = "products", keyGenerator = "cacheKeyGenerator")
            }
    )
    public void addProductsToCategory(Set<Product> newProducts, long categoryId) {
        productsRepository.saveAll(newProducts);

        categoriesRepository.findById(categoryId).ifPresent(category -> {
            var products = SetUtils.emptyIfNull(category.getProducts());
            products.addAll(newProducts);
            category.setProducts(products);
            categoriesRepository.save(category);
        });
    }

    @Cacheable(value = "categories", keyGenerator = "cacheKeyGenerator")
    public Iterable<Category> allCategories() {
        return categoriesRepository.findAll();
    }

    @CachePut(value = "categories", keyGenerator = "cacheKeyGenerator")
    public void createCategory(Category category) {
        categoriesRepository.save(category);
    }

    @Cacheable(value = "categories", keyGenerator = "cacheKeyGenerator")
    public Optional<Category> findById(long id) {
        return categoriesRepository.findById(id);
    }

    @Cacheable(value = "categories", keyGenerator = "cacheKeyGenerator")
    public Set<Product> showCategoryProducts(long id) {
        return categoriesRepository.findById(id).map(Category::getProducts).orElseGet(HashSet::new);
    }


}
