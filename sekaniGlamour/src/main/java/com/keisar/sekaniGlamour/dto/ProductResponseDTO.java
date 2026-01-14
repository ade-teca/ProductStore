package com.keisar.sekaniGlamour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {
    private String name;
    private double price;
    private String category;
    private String brand;
    private boolean available;
    private int quantity;

}
