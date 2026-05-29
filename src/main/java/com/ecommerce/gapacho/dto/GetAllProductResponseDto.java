package com.ecommerce.gapacho.dto;

import java.util.List;

public class GetAllProductResponseDto {
    private Long id;

    private String name;

    private Double price;

    private String category;

    private String seller;

    private Long numberOfReviews = 0L;

    private Double ratings = 0.0;

    private ProductImageDto images;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Long getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Long numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public ProductImageDto getImages() {
        return images;
    }

    public void setImages(ProductImageDto images) {
        this.images = images;
    }
}
