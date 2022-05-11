package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.SubService;
import org.maktab.Part2MaktabFinalProject.repository.SubServiceRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubServiceService implements BaseService<SubService, Long> {
    SubServiceRepository subServiceRepository;

    @Override
    public SubService saveOrUpdate(SubService subService) {
        return subServiceRepository.save(subService);
    }

    @Override
    public List<SubService> findAll() {
        return subServiceRepository.findAll();
    }

    @Override
    public SubService findById(Long id) {
        return subServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        subServiceRepository.deleteById(id);
    }
}
