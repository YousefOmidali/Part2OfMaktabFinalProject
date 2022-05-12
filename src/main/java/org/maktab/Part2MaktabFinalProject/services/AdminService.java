package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.Admin;
import org.maktab.Part2MaktabFinalProject.repository.AdminRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService implements BaseService<Admin, Long> {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    @Transactional
    public Admin saveOrUpdate(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    @Transactional
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    @Transactional
    public Admin findById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    @Transactional
    public Admin login(String username, String password) {
        return adminRepository.findAdminByUsernameAndPassword(username, password);
    }

    @Transactional
    public List<Admin> gridSearch(String firstName,
                                  String lastName,
                                  String email,
                                  String username) {
        return adminRepository.findAdminsByFirstnameOrLastnameOrEmailOrUsername(firstName, lastName, email, username);
    }
}
