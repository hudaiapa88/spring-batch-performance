package com.uc.batch.model.dto.product;

import com.uc.batch.model.dto.base.TimestampBaseDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponse extends TimestampBaseDto {
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
