package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.Experts;
import org.maktab.Part2MaktabFinalProject.entity.Order;
import org.maktab.Part2MaktabFinalProject.entity.SubService;
import org.maktab.Part2MaktabFinalProject.repository.OrderRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements BaseService<Order, Long> {
    OrderRepository orderRepository;

    @Override
    public Order saveOrUpdate(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
    public List<Order> allOrdersOfSubService(SubService subService) {
        return orderRepository.findAllBySubServiceEquals(subService);
    }
}
