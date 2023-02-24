package com.xiaomizhou.common.utils;

import com.xiaomizhou.common.entity.ValueNameEnum;

/**
 * @author xiaomizhou
 * @date 2023/2/20 21:37 
 * @email 521jx123@gmail.com
 */
public final class ValueNameEnumUtils {

    public ValueNameEnumUtils() {
    }

    public static <E extends Enum<?> & ValueNameEnum> E valueOf(Class<E> enumClass, int value) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getValue() == value) {
                return e;
            }
        }
        return null;
    }
}
