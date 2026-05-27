package com.ecommerce.gapacho.controller;

import com.ecommerce.gapacho.dto.ProductRequestDto;
import com.ecommerce.gapacho.dto.ProductResponseDto;
import com.ecommerce.gapacho.services.ProductServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts(){
        List<ProductResponseDto> product = productServices.getAllProducts();
        return product;
    }


    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductRequestDto productDto){
        productServices.createProduct(productDto);
        return ResponseEntity.ok().body("Product added SuccessFully Gapacho!");
    }


}
