package com.ecommerce.gapacho.services;

import com.ecommerce.gapacho.dto.ProductReviewRequestDto;
import com.ecommerce.gapacho.entity.Product;
import com.ecommerce.gapacho.entity.ProductReview;
import com.ecommerce.gapacho.repository.ProductRepository;
import com.ecommerce.gapacho.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReviewServices {
    @Autowired
    private ProductReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addReview(ProductReviewRequestDto reviewDto){
        ProductReview productReview = convertToEntity(reviewDto);
        reviewRepository.save(productReview);

    }

    public ProductReview convertToEntity(ProductReviewRequestDto reviewDto){
        ProductReview productReview = new ProductReview();
        Double ratings = reviewDto.getRatings();
        productReview.setRatings(ratings);
        productReview.setComment(reviewDto.getComment());

        Product product = productRepository.findById(reviewDto.getProductId()).orElseThrow(() -> new RuntimeException("Product Id Not Found!"));
        product.setRatings((product.getRatings() + ratings)/2);

        productReview.setProduct(product);

        return productReview;

    }

}
