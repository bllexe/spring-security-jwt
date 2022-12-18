package com.tigris.springsecurityjwt.controller;

import com.tigris.springsecurityjwt.entities.Product;
import com.tigris.springsecurityjwt.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllPosts() {
        //todo ProductDto can use
        return productService.getAllProduct();
    }

    @PostMapping
    public Product createOnePost(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

}
