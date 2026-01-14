package com.keisar.sekaniGlamour.controller;


import com.keisar.sekaniGlamour.dto.ProductRequestDTO;
import com.keisar.sekaniGlamour.dto.ProductResponseDTO;
import com.keisar.sekaniGlamour.model.Product;
import com.keisar.sekaniGlamour.repository.ProductRepository;
import com.keisar.sekaniGlamour.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Productcontroller {

    @Autowired
    private final ProductService productService;

    @PostMapping("/products")
    ResponseEntity<Void> addProduct(@RequestBody ProductRequestDTO request){
        productService.addProduct(request);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/products")
    ResponseEntity<Void> updateProduct(@RequestBody ProductRequestDTO request){
        productService.updateProduct(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/products/id/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();

    }

    //Querying

    @GetMapping("/products")
    ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> productResponseDTOS = productService.getAllProducts();
        return ResponseEntity.ok(productResponseDTOS);
    }
    @GetMapping("/products/id/{id}")
    ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id){
        ProductResponseDTO productResponseDTO = productService.getProductById(id);
        return ResponseEntity.ok(productResponseDTO);
    }

    ResponseEntity<List<ProductResponseDTO>> getProductByName(String name){
        List<ProductResponseDTO> productResponseDTOS = productService.getProductByName(name);
        return ResponseEntity.ok(productResponseDTOS);
    }
}
