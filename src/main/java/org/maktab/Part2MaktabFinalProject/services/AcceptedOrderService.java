package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.AcceptedOrder;
import org.maktab.Part2MaktabFinalProject.repository.AcceptedOrderRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AcceptedOrderService implements BaseService<AcceptedOrder, Long> {
    AcceptedOrderRepository acceptedOrderRepository;

    @Override
    @Transactional
    public AcceptedOrder saveOrUpdate(AcceptedOrder acceptedOrder) {
        return acceptedOrderRepository.save(acceptedOrder);
    }

    @Override
    @Transactional
    public List<AcceptedOrder> findAll() {
        return acceptedOrderRepository.findAll();
    }

    @Override
    @Transactional
    public AcceptedOrder findById(Long id) {

        return acceptedOrderRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        acceptedOrderRepository.deleteById(id);
    }
}
