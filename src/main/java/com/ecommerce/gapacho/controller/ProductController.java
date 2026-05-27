package com.ecommerce.gapacho.controller;

import com.ecommerce.gapacho.dto.ProductRequestDto;
import com.ecommerce.gapacho.dto.ProductResponseDto;
import com.ecommerce.gapacho.services.ProductServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts(@RequestParam @DefaultValue("0") int pageNo, @RequestParam @DefaultValue("3") int pageSize ){
        List<ProductResponseDto> products = productServices.getAllProducts(pageNo, pageSize);
        return products;
    }

    @GetMapping("/products/search")
    public List<ProductResponseDto> getFilteredProduct(@RequestParam(required = false) String searchText , @RequestParam(required = false) String category){
        List<ProductResponseDto> products = productServices.getFilteredProduct(searchText, category);
        return products;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductRequestDto productDto){
        productServices.createProduct(productDto);
        return ResponseEntity.ok().body("Product added SuccessFully Gapacho!");
    }


}
