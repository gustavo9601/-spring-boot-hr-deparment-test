package com.springboot.hr.deparment.test.hr.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Common {

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @PrePersist
    public void prePersist() {
        this.setUpdatedAt(LocalDate.now());
        this.setCreatedAt(LocalDate.now());
        this.setIsActive(true);
    }

    @PreUpdate
    public void preUpdate() {
        this.setUpdatedAt(LocalDate.now());
    }

}
