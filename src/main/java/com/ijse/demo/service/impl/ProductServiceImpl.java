package com.ijse.demo.service.impl;

import com.ijse.demo.dto.ProductDto;
import com.ijse.demo.entity.Category;
import com.ijse.demo.entity.Product;
import com.ijse.demo.repository.CategoryRepository;
import com.ijse.demo.repository.ProductRepository;
import com.ijse.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElse(null);
        if (category!=null){
            Product product = new Product();
            product.setName(productDto.getName());
            product.setCategory(category);
            product.setPrice(productDto.getPrice());
            product.setQty(productDto.getQty());
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(long id, Product product) {
        Product currentProduct = productRepository.findById(id).orElse(null);
        if (currentProduct!=null){
            product.setName(product.getName());
            product.setCategory(product.getCategory());
            product.setPrice(product.getPrice());
            product.setQty(product.getQty());
            return productRepository.save(product);
        }else{
            return null;
        }
    }

    @Override
    public List<Product> getProductsByCategory(long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category!=null){
            return productRepository.findProductsByCategory(category);
        }
        return null;
    }
}
