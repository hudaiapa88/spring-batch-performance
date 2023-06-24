package com.uc.batch.model.entity.product;

import com.uc.batch.model.entity.base.AbstractTimestampEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Product extends AbstractTimestampEntity {
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
