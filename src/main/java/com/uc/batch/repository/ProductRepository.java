package com.uc.batch.repository;

import com.uc.batch.model.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>{


}
