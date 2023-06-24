package com.uc.batch.controller.product;

import com.uc.batch.model.dto.product.SaveProductRequest;
import com.uc.batch.model.dto.product.UpdateProductRequest;
import com.uc.batch.model.entity.product.Product;
import com.uc.batch.service.ProductManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductManager productManager;
    @PostMapping
    public Product save( @RequestBody SaveProductRequest saveProductRequest){
        return productManager.save(saveProductRequest);
    }
    @PostMapping("/multi")
    public List<Product> saveMulti(){
        return productManager.saveMulti();
    }

    @PutMapping("/{id}")

    public Product update(@PathVariable Long id,   @RequestBody UpdateProductRequest updateProductRequest){
        return productManager.update(id,updateProductRequest);
    }

    @GetMapping("/pageable")
    public Page<Product> getAll(Pageable pageable){
        return productManager.getAll(pageable);
    }
    @GetMapping()
    public List<Product> getAll(){
        return productManager.getAll();
    }
}
