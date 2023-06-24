package com.uc.batch.model.entity.base;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.SEQUENCE;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1)
    private Long id;

}
