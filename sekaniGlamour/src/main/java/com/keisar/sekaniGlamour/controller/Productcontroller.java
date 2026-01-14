package com.keisar.sekaniGlamour.controller;


import com.keisar.sekaniGlamour.dto.ProductRequestDTO;
import com.keisar.sekaniGlamour.dto.ProductResponseDTO;
import com.keisar.sekaniGlamour.model.Product;
import com.keisar.sekaniGlamour.repository.ProductRepository;
import com.keisar.sekaniGlamour.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Productcontroller {

    private final ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductRequestDTO request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable Long id, @RequestBody ProductRequestDTO request) {

        ProductResponseDTO productResponseDTO = productService.updateProduct(id, request);
        return ResponseEntity.ok(productResponseDTO);
    }
}
