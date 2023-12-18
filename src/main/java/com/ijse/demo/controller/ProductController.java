package com.ijse.demo.controller;

import com.ijse.demo.dto.ProductDto;
import com.ijse.demo.entity.Product;
import com.ijse.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        Product product = productService.getProductById(id);
        if (product!=null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.updateProduct(id,product));
    }
    @GetMapping("/categories/{id}/products")
    public ResponseEntity<List<Product>> getProductsByCategories(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsByCategory(id));
    }
}
