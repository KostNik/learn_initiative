package com.learn.initiative.store.controller;

import com.learn.initiative.store.model.dto.Category;
import com.learn.initiative.store.model.dto.Product;
import com.learn.initiative.store.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    @ApiOperation("Get all categories")
    public Iterable<Category> allCategories() {
        return categoryService.allCategories();
    }

    @PostMapping("/")
    @ApiOperation("Create new category")
    public void createCategory(Category category) {
        categoryService.createCategory(category);
    }

    @GetMapping("/{categoryId}")
    @ApiOperation("Get category info")
    public Optional<Category> showCategory(@PathVariable(name = "categoryId") long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/{categoryId}/products")
    @ApiOperation("Get category products")
    public Set<Product> showCategoryProducts(@PathVariable(name = "categoryId") long id) {
        return categoryService.showCategoryProducts(id);
    }


    @PutMapping("/{categoryId}")
    @ApiOperation("Add products to category")
    public void addProductsToCategory(@PathVariable(name = "categoryId") long id, Set<Product> products) {
        categoryService.addProductsToCategory(products, id);
    }


}
