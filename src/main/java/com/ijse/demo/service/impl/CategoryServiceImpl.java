package com.ijse.demo.service.impl;

import com.ijse.demo.entity.Category;
import com.ijse.demo.repository.CategoryRepository;
import com.ijse.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category currentCategory = categoryRepository.findById(id).orElse(null);
        if (currentCategory!=null){
            currentCategory.setName(category.getName());
            return categoryRepository.save(currentCategory);
        }else{
            return null;
        }
    }
}
