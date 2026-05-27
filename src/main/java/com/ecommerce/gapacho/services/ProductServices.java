package com.ecommerce.gapacho.services;

import com.ecommerce.gapacho.entity.Product;
import com.ecommerce.gapacho.repository.ProductRepository;

import java.util.List;

public class ProductServices {

    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
