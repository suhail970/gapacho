package com.ecommerce.gapacho.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name Field must not be blank!")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Price Field must not be blank!")
    @Column(nullable = false)
    private Double price;

    @NotBlank(message = "Category field must not be Blank!")
    @Column(nullable = false)
    private String category;

    @NotBlank(message = "Category field must not be Blank!")
    @Column(nullable = false)
    private String description;

    @NotBlank(message = "Seller field must not be Blank!")
    @Column(nullable = false)
    private String seller;

    private Long numberOfReviews = 0L;

    @Min(0)@Max(5)
    private Double ratings = 0.0;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductImages> images;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductReviews> reviews;

    public Product(Long id, String name, Double price, String category, String description, String seller) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.seller = seller;
    }
    public Product() {
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

    public List<ProductImages> getImages() {
        return images;
    }
    public void setImages(List<ProductImages> images) {
        this.images = images;
    }
    public List<ProductReviews> getReviews() {
        return reviews;
    }
    public void setReviews(List<ProductReviews> reviews) {
        this.reviews = reviews;
    }
}
