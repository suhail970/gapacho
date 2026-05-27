package com.ecommerce.gapacho.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ProductRequestDto {
    private Long id;

    @NotBlank(message = "Name Field must not be blank!")
    private String name;

    @NotNull(message = "Price Field must not be blank!")
    private Double price;

    @NotBlank(message = "Category field must not be Blank!")
    private String category;

    @NotBlank(message = "Category field must not be Blank!")
    private String description;

    @NotBlank(message = "Seller field must not be Blank!")
    private String seller;

    private List<ProductImageDto> images;


    public ProductRequestDto(Long id, String name, Double price, String category, String description, String seller, List<ProductImageDto> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.seller = seller;
        this.images = images;
    }
    public ProductRequestDto() {
    }
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSeller() {
        return seller;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }

    public List<ProductImageDto> getImages() {
        return images;
    }
    public void setImages(List<ProductImageDto> images) {
        this.images = images;
    }

}
