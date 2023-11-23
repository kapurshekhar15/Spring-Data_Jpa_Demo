package com.springdatajpa.springboot.Repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
