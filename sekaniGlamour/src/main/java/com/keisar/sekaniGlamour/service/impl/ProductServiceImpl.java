package com.keisar.sekaniGlamour.service.impl;

import com.keisar.sekaniGlamour.dto.ProductRequestDTO;
import com.keisar.sekaniGlamour.dto.ProductResponseDTO;
import com.keisar.sekaniGlamour.model.Product;
import com.keisar.sekaniGlamour.repository.ProductRepository;
import com.keisar.sekaniGlamour.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper mapper;


    @Override
    public void addProduct(ProductRequestDTO request) {
        Product product = mapper.map(request, Product.class);
        productRepository.save(product);
    }

    @Override
    public void updateProduct(ProductRequestDTO request) {
        Product product = mapper.map(request, Product.class);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> responseDTOS= products.stream()
                .map(product -> mapper.map(product, ProductResponseDTO.class))
                .toList();
        return responseDTOS;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        ProductResponseDTO productResponseDTO = mapper.map(product, ProductResponseDTO.class);
        return productResponseDTO;
    }

    @Override
    public List<ProductResponseDTO> getProductByName(String name) {
        List<Product> products = productRepository.findByName(name);
        List<ProductResponseDTO> responseDTOS = products.stream()
                .map(product -> mapper.map(product, ProductResponseDTO.class))
                .toList();

        return responseDTOS;
    }


}