package com.xiaomizhou.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public abstract class BaseSortableEntity<U, ID> extends BaseDeletableEntity<U, ID>
        implements Sortable<U, ID>, Serializable {
    private Integer orderNo;
}
