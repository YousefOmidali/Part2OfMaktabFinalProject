package org.maktab.Part2MaktabFinalProject.repository;

import org.maktab.Part2MaktabFinalProject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findAdminByUsernameAndPassword(String username, String password);

    Customer findAdminByFirstnameOrLastnameOrEmailOrUsername(
            String firstname
            , String lastname
            , String email
            , String username);
}
