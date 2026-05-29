package com.ecommerce.gapacho.controller;

import com.ecommerce.gapacho.dto.GetAllProductResponseDto;
import com.ecommerce.gapacho.dto.ProductRequestDto;
import com.ecommerce.gapacho.dto.ProductResponseDto;
import com.ecommerce.gapacho.dto.ProductUpdateRequestDto;
import com.ecommerce.gapacho.services.ProductServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping
    public Map<String, Object> getAllProducts(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "3") int pageSize ){
        Map<String, Object> products = productServices.getAllProducts(pageNo, pageSize);
        return products;
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id){
        ProductResponseDto productResponseDto = productServices.getProduct(id);
        return productResponseDto;
    }


    @GetMapping("/search")
    public List<GetAllProductResponseDto> getFilteredProduct(@RequestParam(required = false) String searchText , @RequestParam(required = false) String category){
        List<GetAllProductResponseDto> products = productServices.getFilteredProduct(searchText, category);
        return products;
    }


    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductRequestDto productDto){
        productServices.createProduct(productDto);
        return ResponseEntity.ok().body("Product added SuccessFully Gapacho!");
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<String> alterProduct(@PathVariable Long productId, @RequestBody ProductUpdateRequestDto productUpdateDto){
        productServices.updateProduct(productId, productUpdateDto);
        return ResponseEntity.ok().body("Product Updated Successfully!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productServices.deleteProduct(id);
        return ResponseEntity.ok().body("Product Successfully deleted!");
    }


}
