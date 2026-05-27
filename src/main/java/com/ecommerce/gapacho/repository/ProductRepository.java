package com.ecommerce.gapacho.repository;

import com.ecommerce.gapacho.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
