package com.ecommerce.gapacho.services;

import com.ecommerce.gapacho.dto.ProductRequestDto;
import com.ecommerce.gapacho.dto.ProductImageDto;
import com.ecommerce.gapacho.dto.ProductResponseDto;
import com.ecommerce.gapacho.dto.ProductReviewDto;
import com.ecommerce.gapacho.entity.Product;
import com.ecommerce.gapacho.entity.ProductImage;
import com.ecommerce.gapacho.entity.ProductReview;
import com.ecommerce.gapacho.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponseDto> getAllProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productsDto = convertToDto(products);
        return productsDto;
    }
    public List<ProductResponseDto> convertToDto(List<Product> products) {
        List<ProductResponseDto> productRequestDto = new ArrayList<>();

        for (Product product : products) {
            ProductResponseDto dto = new ProductResponseDto();
            dto.setName(product.getName());
            dto.setPrice(product.getPrice());
            dto.setCategory(product.getCategory());
            dto.setDescription(product.getDescription());
            dto.setSeller(product.getSeller());
            dto.setRatings(product.getRatings());
            dto.setNumberOfReviews(product.getNumberOfReviews());

            List<ProductImageDto> imagesDto = new ArrayList<>();
            for (ProductImage image : product.getImages()) {
                ProductImageDto imgDto = new ProductImageDto();
                imgDto.setPublicUrl(image.getPublicUrl());
                imagesDto.add(imgDto);
            }
            dto.setImages(imagesDto);

            List<ProductReviewDto> reviewDto = new ArrayList<>();
            for (ProductReview rev : product.getReviews()) {
                ProductReviewDto revDto = new ProductReviewDto();
                revDto.setComment(rev.getComment());
                revDto.setRatings(rev.getRatings());
                reviewDto.add(revDto);
            }
            dto.setReviews(reviewDto);

            productRequestDto.add(dto);

        }
        return productRequestDto;
    }

    public void createProduct(ProductRequestDto productDto){
        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(productDto.getCategory());
        product.setDescription(productDto.getDescription());
        product.setSeller(productDto.getSeller());

        if(productDto.getImages() != null){
            List<ProductImage> productImage = new ArrayList<>();
            for(ProductImageDto img: productDto.getImages()){
                ProductImage proImg = new ProductImage();
                proImg.setPublicUrl(img.getPublicUrl());
                proImg.setUrl(img.getPublicUrl());
                proImg.setProduct(product);
                productImage.add(proImg);
            }

            product.setImages(productImage);
        }

        productRepository.save(product);

    }
}
