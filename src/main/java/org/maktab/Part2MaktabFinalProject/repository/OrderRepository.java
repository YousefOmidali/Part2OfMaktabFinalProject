package org.maktab.Part2MaktabFinalProject.repository;

import org.maktab.Part2MaktabFinalProject.entity.Order;
import org.maktab.Part2MaktabFinalProject.entity.OrderStatus;
import org.maktab.Part2MaktabFinalProject.entity.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllBySubServiceEqualsAndOrderStatusEquals(SubService subService,OrderStatus orderStatus);

//    @Query("FROM org.maktab.Part2MaktabFinalProject.entity.Order o WHERE o. =: id  ")
//    List<Order> loadByFirstName(@Param("id") Long id);
}
