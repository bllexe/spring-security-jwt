package com.tigris.springsecurityjwt.service.impl;

import com.tigris.springsecurityjwt.entities.Product;
import com.tigris.springsecurityjwt.repo.ProductRepository;
import com.tigris.springsecurityjwt.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
