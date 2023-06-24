package com.uc.batch.model.dto.product;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateProductRequest {

    private String title;
    private Long categoryId;

    private BigDecimal price;

    private Integer quantity;
}
