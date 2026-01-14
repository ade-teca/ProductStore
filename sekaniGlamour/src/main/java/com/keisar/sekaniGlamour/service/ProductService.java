package com.keisar.sekaniGlamour.service;

import com.keisar.sekaniGlamour.dto.ProductRequestDTO;
import com.keisar.sekaniGlamour.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO request);




    ProductResponseDTO updateProduct(Long id, ProductRequestDTO request);

    void addProduct(ProductRequestDTO request);
    void updateProduct(ProductRequestDTO request);
    void deleteProduct(Long id);

    //Querying

    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO getProductByName(String name);
}
