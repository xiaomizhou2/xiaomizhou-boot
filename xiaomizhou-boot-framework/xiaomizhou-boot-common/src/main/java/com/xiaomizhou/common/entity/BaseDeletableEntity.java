package com.xiaomizhou.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author xiaomizhou
 * @date 2023/2/20 20:52
 * @email 521jx123@gmail.com
 */
@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public abstract class BaseDeletableEntity<U, ID> extends BaseDescribableEntity<U, ID>
        implements Deletable<U, ID>, Serializable {
    private Boolean deleted;
}
