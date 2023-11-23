package com.springdatajpa.springboot.Repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class
ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;


    @Test
    void saveMethod()
    {
        // create product
        Product product = new Product();
        product.setName("product1");
        product.setDescription("product 1 description");
        product.setSku("1000ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        // save product

       Product savedObject =  productRepository.save(product);

        // display the product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());

    }

    @Test
    void updateUsingSaveMethod()
    {
        // find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();


        // update entity information

        product.setName("updated product1");
        product.setDescription("updated product1 descriptioon");

        //save updated entity

        productRepository.save(product);
    }

    @Test
    void findByIdMethod()
    {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        System.out.println(product.toString());
    }

    @Test
    void saveAllMethod(){

        // create product
        Product product2 = new Product();
        product2.setName("product2");
        product2.setDescription("product 2 description");
        product2.setSku("19ABC");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product2.png");


        // create product
        Product product3 = new Product();
        product3.setName("product3");
        product3.setDescription("product 3 description");
        product3.setSku("10ABC");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product2,product3));

    }

    @Test
    void findAllMethod(){

       List<Product> products =  productRepository.findAll();

       products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    void deleteByIdMethod(){

        Long id = 1L;
        productRepository.deleteById(id);

    }

    @Test
    void deleteMethod(){

        // find an entity by id

        Long id = 8L;
        Product product = productRepository.findById(id).get();

        // delete(entity)

        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){

       // productRepository.deleteAll();

       Product product= productRepository.findById(11L).get();

       Product product1 =  productRepository.findById(12L).get();

       productRepository.deleteAll(List.of(product,product1));


    }

    @Test
    void countMethod(){

       Long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existById(){
        Long id = 13L;
      boolean result =  productRepository.existsById(id);
        System.out.println(result);
    }

}