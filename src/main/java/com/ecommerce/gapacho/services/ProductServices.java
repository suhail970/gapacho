package com.ecommerce.gapacho.services;

import com.ecommerce.gapacho.dto.ProductRequestDto;
import com.ecommerce.gapacho.dto.ProductImageDto;
import com.ecommerce.gapacho.dto.ProductResponseDto;
import com.ecommerce.gapacho.dto.ProductReviewResponseDto;
import com.ecommerce.gapacho.entity.Product;
import com.ecommerce.gapacho.entity.ProductImage;
import com.ecommerce.gapacho.entity.ProductReview;
import com.ecommerce.gapacho.repository.ProductRepository;
import com.ecommerce.gapacho.spec.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductSpecification productSpec;

    public List<ProductResponseDto> getAllProducts(int pageNo, int pageSize){
        Pageable pages = PageRequest.of(pageNo, pageSize);
        Page<Product> products = productRepository.findAll(pages);
        List<ProductResponseDto> productsDto = new ArrayList<>();
        for(Product product:products) {
            productsDto.add(convertToDto(product));
        }
        return productsDto;
    }

    public List<ProductResponseDto> getFilteredProduct(String searchText, String category){
        Specification<Product> spec = Specification.where((from, cb) -> cb.conjunction());
        if(searchText != null){
            spec = spec.and(productSpec.filterSearch(searchText));
        }
        if(category != null){
            spec = spec.and(productSpec.filterCategory(category));
        }
        Sort sort = Sort.by("price").ascending();
        List<Product> response = productRepository.findAll(spec,sort);

        List<ProductResponseDto> responseDto = new ArrayList<>();

        for(Product product:response){
            ProductResponseDto dto = convertToDto(product);
            responseDto.add(dto);
        }

        return responseDto;
    }

    public ProductResponseDto convertToDto(Product product) {
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

        List<ProductReviewResponseDto> reviewDto = new ArrayList<>();
        for (ProductReview rev : product.getReviews()) {
            ProductReviewResponseDto revDto = new ProductReviewResponseDto();
            revDto.setComment(rev.getComment());
            revDto.setRatings(rev.getRatings());
            reviewDto.add(revDto);
        }
        dto.setReviews(reviewDto);

        return dto;
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
