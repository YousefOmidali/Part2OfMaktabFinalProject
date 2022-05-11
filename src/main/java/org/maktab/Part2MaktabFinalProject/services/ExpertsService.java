package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.Customer;
import org.maktab.Part2MaktabFinalProject.entity.Experts;
import org.maktab.Part2MaktabFinalProject.repository.ExpertsRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExpertsService implements BaseService<Experts, Long> {
    ExpertsRepository expertsRepository;

    @Override
    @Transactional
    public Experts saveOrUpdate(Experts experts) {
        return expertsRepository.save(experts);
    }

    @Override
    @Transactional
    public List<Experts> findAll() {
        return expertsRepository.findAll();
    }

    @Override
    @Transactional
    public Experts findById(Long id) {
        return expertsRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        expertsRepository.deleteById(id);
    }

    @Transactional
    public Experts login(String username, String password) {
        return expertsRepository.findAdminByUsernameAndPassword(username, password);
    }

    @Transactional
    public List<Experts> gridSearch(String firstName,
                                    String lastName,
                                    String email,
                                    String username) {
        return expertsRepository.findExpertsByFirstnameOrLastnameOrEmailOrUsername(firstName, lastName, email, username);
    }
}
