package com.tigris.springsecurityjwt.service;

import com.tigris.springsecurityjwt.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<Product> getAllProduct();

    public Product saveProduct(Product product);
}
