package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.Service;
import org.maktab.Part2MaktabFinalProject.repository.ServiceRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements BaseService<Service, Long> {
    ServiceRepository serviceRepository;

    @Override
    @Transactional
    public Service saveOrUpdate(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    @Transactional
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    @Transactional
    public Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        serviceRepository.deleteById(id);
    }
}
