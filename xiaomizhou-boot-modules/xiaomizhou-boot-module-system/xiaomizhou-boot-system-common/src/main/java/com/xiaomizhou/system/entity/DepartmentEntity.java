package com.xiaomizhou.system.entity;

import com.xiaomizhou.common.entity.BaseSortableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author xiaomizhou
 * @date 2023/2/25
 * @email 521jx123@gmail.com
 */
@Data
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class DepartmentEntity extends BaseSortableEntity<UserEntity, String> {
    private String code;
    private String name;
    private Integer status;
    private OrganizationEntity organization;
    private DepartmentEntity parent;
    private List<DepartmentEntity> children;
}
