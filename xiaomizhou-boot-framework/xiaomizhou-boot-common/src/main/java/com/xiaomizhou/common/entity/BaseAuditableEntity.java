package com.xiaomizhou.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Auditable;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author xiaomizhou
 * @date 2023/2/20 20:51 
 * @email 521jx123@gmail.com
 */
@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public abstract class BaseAuditableEntity<U, ID> extends BasePersistableEntity<ID>
        implements Auditable<U, ID, LocalDateTime> {

    private LocalDateTime createdTime;
    private LocalDateTime lastModifiedTime;
    private U createdUser;
    private U lastModifiedUser;

    @Override
    public Optional<U> getCreatedBy() {
        return Optional.ofNullable(this.createdUser);
    }

    @Override
    public void setCreatedBy(U createdBy) {
        this.setCreatedUser(createdBy);
    }

    @Override
    public Optional<LocalDateTime> getCreatedDate() {
        return Optional.ofNullable(this.createdTime);
    }

    @Override
    public void setCreatedDate(LocalDateTime createdTime) {
        this.setCreatedTime(createdTime);
    }

    @Override
    public Optional<U> getLastModifiedBy() {
        return Optional.ofNullable(this.lastModifiedUser);
    }

    @Override
    public void setLastModifiedBy(U lastModifiedBy) {
        this.setLastModifiedUser(lastModifiedBy);
    }

    @Override
    public Optional<LocalDateTime> getLastModifiedDate() {
        return Optional.ofNullable(this.lastModifiedTime);
    }

    @Override
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.setLastModifiedTime(lastModifiedDate);
    }
}
