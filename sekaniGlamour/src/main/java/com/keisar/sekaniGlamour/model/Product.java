package com.keisar.sekaniGlamour.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    private String description;

    @Column(nullable = false)
    private double price;

    private int quantity;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String brand;

    private Boolean available;

}
