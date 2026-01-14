package com.keisar.sekaniGlamour.repository;

import com.keisar.sekaniGlamour.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
