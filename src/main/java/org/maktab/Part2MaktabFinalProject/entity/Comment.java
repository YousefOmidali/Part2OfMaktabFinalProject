package org.maktab.Part2MaktabFinalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.maktab.Part2MaktabFinalProject.entity.base.BaseEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Comment extends BaseEntity<Long> {
    private String description;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Order order;
}
