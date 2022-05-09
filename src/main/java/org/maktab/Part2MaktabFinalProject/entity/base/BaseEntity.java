package org.maktab.Part2MaktabFinalProject.entity.base;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public class BaseEntity<ID extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ID id;

    public boolean isNew() {
        return id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        if (id == null && that.id == null)
            return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
