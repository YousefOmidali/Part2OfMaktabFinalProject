package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.AcceptedOrder;
import org.maktab.Part2MaktabFinalProject.repository.AcceptedOrderRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AcceptedOrderService implements BaseService<AcceptedOrder, Long> {
    AcceptedOrderRepository acceptedOrderRepository;

    @Override
    public AcceptedOrder saveOrUpdate(AcceptedOrder acceptedOrder) {
        return acceptedOrderRepository.save(acceptedOrder);
    }

    @Override
    public List<AcceptedOrder> findAll() {
        return acceptedOrderRepository.findAll();
    }

    @Override
    public AcceptedOrder findById(Long id) {

        return acceptedOrderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        acceptedOrderRepository.deleteById(id);
    }
}
