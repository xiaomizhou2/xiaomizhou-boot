package com.xiaomizhou.common.entity;

import java.io.Serializable;

/**
 * @author xiaomizhou
 * @date 2023/2/20 20:52
 * @email 521jx123@gmail.com
 */
public interface Sortable<U, ID> extends Deletable<U, ID>, Serializable {
    Integer getOrderNo();
}
