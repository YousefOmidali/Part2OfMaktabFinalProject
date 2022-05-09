package org.maktab.Part2MaktabFinalProject.entity;

import lombok.*;
import org.maktab.Part2MaktabFinalProject.entity.base.BaseEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order extends BaseEntity<Long> {
    private String signUpTime;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private SubService subService;
    @OneToOne
    private Experts expert;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
