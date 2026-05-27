package com.ecommerce.gapacho.repository;

import com.ecommerce.gapacho.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
}
