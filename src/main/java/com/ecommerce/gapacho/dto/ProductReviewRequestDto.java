package com.ecommerce.gapacho.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class ProductReviewRequestDto {

    private Long id;

    @NotNull(message = "Id Field should be filled!")
    private Long productId;

    @NotNull(message = "Ratings Field should be filled!")
    private Double ratings;

    private String comment;

    public ProductReviewRequestDto(Long id,Double ratings, String comment) {
        this.ratings = ratings;
        this.comment = comment;
        this.id = id;
    }
    public ProductReviewRequestDto() {
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getRatings() {
        return ratings;
    }
    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
