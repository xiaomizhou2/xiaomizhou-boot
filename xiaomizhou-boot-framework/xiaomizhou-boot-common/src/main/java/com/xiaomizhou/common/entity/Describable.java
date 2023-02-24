package com.xiaomizhou.common.entity;

import org.springframework.data.domain.Auditable;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xiaomizhou
 * @date 2023/2/20 20:52
 * @email 521jx123@gmail.com
 */
public interface Describable<U, ID> extends Auditable<U, ID, LocalDateTime>, Serializable {
    String getDescription();
}
