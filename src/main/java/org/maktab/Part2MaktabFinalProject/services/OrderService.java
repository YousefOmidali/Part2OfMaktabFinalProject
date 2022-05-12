package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.Order;
import org.maktab.Part2MaktabFinalProject.entity.SubService;
import org.maktab.Part2MaktabFinalProject.repository.OrderRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService implements BaseService<Order, Long> {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Order saveOrUpdate(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
    public List<Order> allOrdersOfASubService(SubService subService) {
        return orderRepository.findAllBySubServiceEquals(subService);
    }
}
