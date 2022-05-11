package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.SubService;
import org.maktab.Part2MaktabFinalProject.repository.SubServiceRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubServiceService implements BaseService<SubService, Long> {
    SubServiceRepository subServiceRepository;

    public SubServiceService(SubServiceRepository subServiceRepository) {
        this.subServiceRepository = subServiceRepository;
    }

    @Override
    @Transactional
    public SubService saveOrUpdate(SubService subService) {
        return subServiceRepository.save(subService);
    }

    @Override
    @Transactional
    public List<SubService> findAll() {
        return subServiceRepository.findAll();
    }

    @Override
    @Transactional
    public SubService findById(Long id) {
        return subServiceRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        subServiceRepository.deleteById(id);
    }
}
