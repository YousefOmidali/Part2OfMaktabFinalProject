package org.maktab.Part2MaktabFinalProject.repository;

import org.maktab.Part2MaktabFinalProject.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByUsernameAndPassword(String username, String password);

    Admin findAdminByFirstnameOrLastnameOrEmailOrUsername(
            String firstname
            , String lastname
            , String email
            , String username);
    
}
