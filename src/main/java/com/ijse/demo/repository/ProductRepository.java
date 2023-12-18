package com.ijse.demo.repository;

import com.ijse.demo.entity.Category;
import com.ijse.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p from Product p where p.category = :category")
    List<Product> findProductsByCategory(@Param("category")Category category);
}
