package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.Admin;
import org.maktab.Part2MaktabFinalProject.repository.AdminRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminService implements BaseService<Admin, Long> {
    AdminRepository adminRepository;

    @Override
    public Admin saveOrUpdate(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    public Admin login(String username, String password) {
        return adminRepository.findAdminByUsernameAndPassword(username, password);
    }

    public List<Admin> gridSearch(String firstName,
                                  String lastName,
                                  String email,
                                  String username) {
        return adminRepository.findAdminsByFirstnameOrLastnameOrEmailOrUsername(firstName, lastName, email, username);
    }
}
