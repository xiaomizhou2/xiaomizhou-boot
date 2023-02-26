package com.xiaomizhou.system.entity;

import com.xiaomizhou.common.entity.BaseSortableEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
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
public class UserEntity extends BaseSortableEntity<UserEntity, String> {
    private String username;
    private String password;
    private LocalDateTime passwordExpireTime;
    private String nickName;
    private String email;
    private String mobile;
    private String avatar;
    private Integer sex;
    private String idCardNo;
    private Integer status;
    private List<RoleEntity> roles;
    private List<PositionEntity> positions;
}
