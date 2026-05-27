package com.ecommerce.gapacho.controller;


import com.ecommerce.gapacho.dto.ProductReviewRequestDto;
import com.ecommerce.gapacho.services.ProductReviewServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api")
public class ProductReviewController {

    @Autowired
    private ProductReviewServices reviewServices;

    @PostMapping("/products/review")
    public ResponseEntity<String> createReview(@Valid @RequestBody ProductReviewRequestDto requestDto){
        reviewServices.addReview(requestDto);
        return ResponseEntity.ok().body("Review Successfully Sent");
    }
}
