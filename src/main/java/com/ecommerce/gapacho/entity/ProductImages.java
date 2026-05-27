package com.ecommerce.gapacho.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "product_images")
public class ProductImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String url;

    private String publicUrl;

    public ProductImages(Long id, String publicUrl) {
        this.id = id;
        this.publicUrl = publicUrl;
        this.url = "uploads"+publicUrl;
    }
    public ProductImages() {
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getPublicUrl() {
        return publicUrl;
    }
    public void setPublicUrl(String publicUrl) {
        this.publicUrl = publicUrl;
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
