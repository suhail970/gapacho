package com.ecommerce.gapacho.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product_reviews")
public class ProductReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Ratings Field should be filled!")
    @Column(nullable = false)
    private Double ratings = 0.0;

    private String comment;

    public ProductReviews(Double ratings, String comment, Product product, Long id) {
        this.ratings = ratings;
        this.comment = comment;
        this.product = product;
        this.id = id;
    }
    public ProductReviews() {
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

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
