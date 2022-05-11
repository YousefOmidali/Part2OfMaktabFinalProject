package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.Service;
import org.maktab.Part2MaktabFinalProject.repository.ServiceRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements BaseService<Service, Long> {
    ServiceRepository serviceRepository;

    @Override
    public Service saveOrUpdate(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        serviceRepository.deleteById(id);
    }
}
