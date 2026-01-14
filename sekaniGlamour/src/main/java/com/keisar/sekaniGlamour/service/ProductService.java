package com.keisar.sekaniGlamour.service;

import com.keisar.sekaniGlamour.dto.ProductRequestDTO;
import com.keisar.sekaniGlamour.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    void addProduct(ProductRequestDTO request);
    void updateProduct(ProductRequestDTO request);
    void deleteProduct(Long id);

    //Querying

    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(Long id);
    List<ProductResponseDTO> getProductByName(String name);
}
