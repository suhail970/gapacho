package com.ecommerce.gapacho.dto;

import com.ecommerce.gapacho.entity.Product;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class ProductReviewDto {
    private Long id;

    @NotNull(message = "Ratings Field should be filled!")
    private Double ratings = 0.0;

    private String comment;

    public ProductReviewDto(Double ratings, String comment, Long id) {
        this.ratings = ratings;
        this.comment = comment;
        this.id = id;
    }
    public ProductReviewDto() {
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
}
