package com.xiaomizhou.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Persistable;

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
public abstract class BasePersistableEntity<ID> implements Persistable<ID>, Serializable {
    private ID id;

    @Override
    public boolean isNew() {
        return id == null;
    }
}
