package com.ecommerce.gapacho.controller;

import com.ecommerce.gapacho.entity.Product;
import com.ecommerce.gapacho.services.ProductServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductServices productServices;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        List<Product> product = productServices.getAllProducts();
        return product;
    }


}
