package com.xiaomizhou.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author xiaomizhou
 * @date 2023/2/20 20:51
 * @email 521jx123@gmail.com
 */
@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public abstract class BaseDescribableEntity<U, ID> extends BaseAuditableEntity<U, ID>
        implements Describable<U, ID>, Serializable {
    private String description;
}
