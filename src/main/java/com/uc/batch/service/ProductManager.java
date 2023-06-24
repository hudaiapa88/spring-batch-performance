package com.uc.batch.service;

import com.uc.batch.model.dto.product.ProductResponse;
import com.uc.batch.model.dto.product.SaveProductRequest;
import com.uc.batch.model.dto.product.UpdateProductRequest;
import com.uc.batch.model.entity.product.Product;
import com.uc.batch.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductManager  {
    private final ProductRepository productRepository;

    @Transactional
    public Product save(SaveProductRequest saveProductRequest) {
        Product product = new Product();
        product.setTitle(saveProductRequest.getTitle());
        product.setQuantity(saveProductRequest.getQuantity());
        product.setPrice(saveProductRequest.getPrice());
        return productRepository.save(product);
    }

    @Transactional

    public Product update(Long id, UpdateProductRequest updateProductRequest) {
        Product product = findById(id);
        product.setTitle(updateProductRequest.getTitle());
        product.setQuantity(updateProductRequest.getQuantity());
        product.setPrice(updateProductRequest.getPrice());

        return productRepository.save(product);
    }

    private Product findById(Long id) {
        return productRepository.findById(id).get();
    }


    public Page<Product> getAll(Pageable pageable) {
        Pageable customPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().isEmpty() ? Sort.by("createdDateTime").descending() : pageable.getSort());

        return productRepository.findAll(customPageable);
    }


    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<Product> saveMulti() {
        List<Product> products=createProducts();
        long start = System.currentTimeMillis();
        products=  productRepository.saveAll(products);
        long end = System.currentTimeMillis();
        log.info("total time : "+TimeUnit.MILLISECONDS.toSeconds(end-start));
        return products;
    }

    private List<Product> createProducts() {
        List<Product> products= new ArrayList<>();
        for (int i=1;i<10000;i++){
            Product product= new Product();
            product.setTitle("product"+i);
            product.setPrice(new BigDecimal(100).add(new BigDecimal(i)));
            product.setQuantity(i);
            products.add(product);
        }
        return products;
    }
}
