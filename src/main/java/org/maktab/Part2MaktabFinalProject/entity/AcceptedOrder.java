package org.maktab.Part2MaktabFinalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.maktab.Part2MaktabFinalProject.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class AcceptedOrder extends BaseEntity<Long> {
    @OneToOne
    private Order order;
    @OneToOne
    private Suggestion suggestion;
}
