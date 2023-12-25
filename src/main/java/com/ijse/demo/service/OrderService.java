package com.ijse.demo.service;

import com.ijse.demo.dto.OrderDto;
import com.ijse.demo.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(long id);
    Order createOrder(OrderDto order);
}
