package org.maktab.Part2MaktabFinalProject.entity;

import lombok.*;
import org.maktab.Part2MaktabFinalProject.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Service extends BaseEntity<Long> {
    private String description;
}
