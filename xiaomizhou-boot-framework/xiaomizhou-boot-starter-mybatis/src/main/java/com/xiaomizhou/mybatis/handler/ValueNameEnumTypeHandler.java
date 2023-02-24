package com.xiaomizhou.mybatis.handler;

import com.xiaomizhou.common.entity.ValueNameEnum;
import com.xiaomizhou.common.utils.ValueNameEnumUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xiaomizhou
 * @date 2023/2/22
 * @email 521jx123@gmail.com
 */
public class ValueNameEnumTypeHandler<E extends Enum<?> & ValueNameEnum> extends BaseTypeHandler<ValueNameEnum> {

    private Class<E> type;

    public ValueNameEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ValueNameEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return rs.wasNull() ? null : valueOf(code);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return rs.wasNull() ? null : valueOf(code);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return cs.wasNull() ? null : valueOf(code);
    }

    /**
     * 根据枚举值返回枚举示例
     *
     * @param code 枚举值
     * @return 枚举实例
     */
    private E valueOf(int code) {
        try {
            return ValueNameEnumUtils.valueOf(type, code);
        } catch (Exception ex) {
            throw new IllegalArgumentException(
                    "Cannot convert " + code + " to " + type.getSimpleName() + " by code value.", ex);
        }
    }
}
