package com.ijse.demo.service.impl;

import com.ijse.demo.dto.OrderDto;
import com.ijse.demo.entity.Order;
import com.ijse.demo.entity.Product;
import com.ijse.demo.repository.OrderRepository;
import com.ijse.demo.repository.ProductRepository;
import com.ijse.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(OrderDto orderDto) {
        List<Long> products = orderDto.getProducts();
        Order order = new Order();
        Set<Product> productSet = new HashSet<>();
        Double total = 0.0;
        for (Long productId:products){
            Product product = productRepository.findById(productId).orElse(null);
            if (product!=null && product.getQty()!=0){
                productSet.add(product);
                total+=product.getPrice();
            }
        }
        order.setTotal(total);
        order.setProducts(productSet);
        order.setTax(order.getTotal()*0.15);
        order.setOrderTime(LocalDateTime.now());
        return orderRepository.save(order);
    }
}
