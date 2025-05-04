package com.RaviLearning.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RaviLearning.product_service.model.Product;

public interface productRepository extends JpaRepository<Product, Long> {

}
