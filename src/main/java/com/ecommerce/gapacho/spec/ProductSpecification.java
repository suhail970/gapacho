package com.ecommerce.gapacho.spec;

import com.ecommerce.gapacho.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProductSpecification {
    public Specification<Product> filterCategory(String category){
        return (root, query, cb) -> cb.equal(root.get("category"), category);
    }

    public Specification<Product> filterSearch(String searchText){
        return (root, query, cb) -> cb.like(root.get("name"), "%"+searchText+"%");
    }
}
