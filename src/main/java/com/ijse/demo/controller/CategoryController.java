package com.ijse.demo.controller;

import com.ijse.demo.entity.Category;
import com.ijse.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/createCategory")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable Long id,@RequestBody Category category){
        return categoryService.updateCategory(id,category);
    }

    @GetMapping("/categories/{id}")
    public Category findCategoryById(Long id){
        return categoryService.getCategoryById(id);
    }
}
