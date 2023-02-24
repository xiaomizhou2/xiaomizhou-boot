package com.xiaomizhou.common.entity;

import java.io.Serializable;

/**
 * @author xiaomizhou
 * @date 2023/2/20 21:24
 * @email 521jx123@gmail.com
 */
public interface Deletable<U, ID> extends Describable<U, ID>, Serializable {
    Boolean getDeleted();
}
