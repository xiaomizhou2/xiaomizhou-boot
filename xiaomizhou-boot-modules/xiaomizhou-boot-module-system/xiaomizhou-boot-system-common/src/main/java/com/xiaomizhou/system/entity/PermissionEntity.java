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
public class PermissionEntity extends BaseSortableEntity<UserEntity, String> {
    private String code;
    private String title;
    private String path;
    private String component;
    private String redirect;
    private String icon;
    private Integer type;
    private String meta;
    private ApplicationEntity application;
    private PermissionEntity parent;
    private List<PermissionEntity> children;
    private List<ApiEntity> apis;
}
