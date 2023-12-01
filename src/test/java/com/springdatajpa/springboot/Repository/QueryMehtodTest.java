package com.springdatajpa.springboot.Repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMehtodTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(13L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription("Product2", "product 2 description");


        products.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });

    }

    @Test
    void findByNameAndDescriptionMethod() {
        List<Product> products = productRepository.findByNameAndDescription("Product2", "product 2 description");


        products.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }

    @Test
    void findDistinctByNameMethod() {
        Product product1 = productRepository.findDistinctByName("Product2");

        System.out.println(product1.getId());
        System.out.println(product1.getName());
        System.out.println(product1.getDescription());

    }


    @Test
    void findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.
                findByPriceGreaterThan(new BigDecimal(100));


        products.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }


    @Test
    void finByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("product2");
        products.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }


    @Test
    void findByNameLikeMethod() {
        List<Product> products = productRepository.findByNameLike("product2");
        products.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(100), new BigDecimal(300));
        products.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }


    @Test
    void findByDateCreatedBetweenMethod() {

        LocalDateTime startDate = LocalDateTime.of(2023, 11, 23, 22, 38, 29);
        LocalDateTime endDate = LocalDateTime.of(2023, 11, 23, 22, 38, 40);

        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);


        products.forEach((x) -> {
            System.out.println(x.getId());
            System.out.println(x.getName());
        });
    }
}


