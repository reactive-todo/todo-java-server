package ru.reactivetodo.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Task extends AbstractPersistable<Long> {
    @Column
    private String description;

    @Column
    private boolean checked;

    @Override
    @Transient
    @JsonIgnore
    public boolean isNew() {
        return super.isNew();
    }
}
