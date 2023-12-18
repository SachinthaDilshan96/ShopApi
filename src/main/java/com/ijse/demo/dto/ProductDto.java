package com.ijse.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {
    private String name;
    private double price;
    private int qty;
    private long categoryId;
}
