package com.uc.batch.model.dto.base;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class TimestampBaseDto extends BaseDto {
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
}
