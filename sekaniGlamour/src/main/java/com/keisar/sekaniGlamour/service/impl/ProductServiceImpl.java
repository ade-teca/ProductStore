package com.keisar.sekaniGlamour.service.impl;

import com.keisar.sekaniGlamour.dto.ProductRequestDTO;
import com.keisar.sekaniGlamour.dto.ProductResponseDTO;
import com.keisar.sekaniGlamour.model.Product;
import com.keisar.sekaniGlamour.repository.ProductRepository;
import com.keisar.sekaniGlamour.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setAvailable(request.getQuantity() > 0);
        product.setCategory(request.getCategory());
        product.setBrand(request.getBrand());

        Product saved = productRepository.save(product);
        return toResponse(saved);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return toResponse(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO request) {
        // PRINCIPAL CORREÇÃO: Buscar o produto existente
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // Atualizar apenas os campos permitidos
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        product.setAvailable(request.getQuantity() > 0);
        product.setCategory(request.getCategory());
        product.setBrand(request.getBrand());

        Product updated = productRepository.save(product);
        return toResponse(updated);
    }

    // Método auxiliar para converter Product -> ProductResponseDTO
    private ProductResponseDTO toResponse(Product product) {
        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setAvailable(product.getAvailable());
        response.setCategory(product.getCategory());
        response.setBrand(product.getBrand());
        response.setPrice(product.getPrice());
        response.setQuantity(product.getQuantity());
        return response;
    }
}