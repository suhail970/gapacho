package com.ecommerce.gapacho.dto;

import com.ecommerce.gapacho.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

public class ProductImageDto {

    @NotBlank
    private String publicUrl;

    public ProductImageDto(String publicUrl) {
        this.publicUrl = publicUrl;
    }

    public ProductImageDto() {
    }


    public String getPublicUrl() {
        return publicUrl;
    }

    public void setPublicUrl(String publicUrl) {
        this.publicUrl = publicUrl;
    }

}
