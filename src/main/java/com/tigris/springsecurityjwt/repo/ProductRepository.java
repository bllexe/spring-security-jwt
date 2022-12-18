package com.tigris.springsecurityjwt.repo;

import com.tigris.springsecurityjwt.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
