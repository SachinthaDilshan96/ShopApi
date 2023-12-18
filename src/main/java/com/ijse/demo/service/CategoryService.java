package com.ijse.demo.service;

import com.ijse.demo.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAllCategories();
    Category createCategory(Category category);
    Category getCategoryById(Long id);
    Category updateCategory(Long id, Category category);

}
