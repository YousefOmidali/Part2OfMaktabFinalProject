package org.maktab.Part2MaktabFinalProject.services;

import org.maktab.Part2MaktabFinalProject.entity.Customer;
import org.maktab.Part2MaktabFinalProject.repository.CustomerRepository;
import org.maktab.Part2MaktabFinalProject.services.base.BaseService;

import java.util.List;

public class CustomerService implements BaseService<Customer,Long> {
    CustomerRepository customerRepository;
    @Override
    public Customer saveOrUpdate(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
customerRepository.deleteById(id);
    }
    public Customer login(String username, String password) {
        return customerRepository.findCustomerByUsernameAndPassword(username, password);
    }

    public List<Customer> gridSearch(String firstName,
                                  String lastName,
                                  String email,
                                  String username) {
        return customerRepository.findCustomersByFirstnameOrLastnameOrEmailOrUsername(firstName, lastName, email, username);
    }
}
