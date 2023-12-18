package com.ijse.demo.service;

import com.ijse.demo.dto.ProductDto;
import com.ijse.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product createProduct(ProductDto product);
    Product getProductById(long id);
    Product updateProduct(long id,Product product);
    List<Product> getProductsByCategory(long id);


}
