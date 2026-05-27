package com.ecommerce.gapacho.dto;

import jakarta.validation.constraints.NotNull;

public class ProductReviewResponseDto {

    private Double ratings;

    private String comment;

    public ProductReviewResponseDto() {
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
}
