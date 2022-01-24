package com.deddy.devtest.service;


import com.deddy.devtest.model.Customer;
import com.deddy.devtest.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findByName(String name) {
        Optional<Customer> exisitingCustomer =  customerRepository.findByName(name);
        if (exisitingCustomer.isPresent()) {
            Customer customer = exisitingCustomer.get();
            customer.setErrDesc("DATA FOUND");
            return customer;

        }
        Customer customer = new Customer();
        customer.setErrDesc("DATA NOT FOUND");
        return customer;
    }

    @Transactional
    public Customer save(Customer customer) {

        Optional<Customer> exisitingCustomer = customerRepository.findByName(customer.getName());
        if (exisitingCustomer.isPresent()) {
            customer.setErrDesc("NAME ALREADY EXIST");
            return  customer;
        }

        Customer cust = new Customer();
        try {
            cust =  customerRepository.save(customer);
            cust.setErrDesc("SUCCESS ");
        }catch (Exception ex) {
            cust.setErrDesc(ex.getMessage());
        }
        return cust;
    }

    @Transactional
    public Customer update(String nama, Customer customer) {

        if (! nama.equalsIgnoreCase(customer.getName()) ){
            customer.setErrDesc("INVALID AUTHORIZATION");
            return customer;
        }

        Optional<Customer> exisitingCustomer = customerRepository.findByName(nama);
        if (exisitingCustomer.isPresent()) {
            Customer cust = exisitingCustomer.get();
            try {
                cust.setName(customer.getName());
                cust.setPhone(customer.getPhone());
                customerRepository.save(cust);
                cust.setErrDesc("SUCCESS");
            }catch (Exception ex) {
                cust.setErrDesc(ex.getMessage());
            }

            return cust;
        }

        Customer cust = new Customer();
        cust.setErrDesc("NAME NOT FOUND !");

        return  cust;
    }

    @Transactional
    public Customer delete(Long id) {

        Customer cust = new Customer();
        Optional<Customer> exisitingCustomer = customerRepository.findById(id);
        if (exisitingCustomer.isPresent()) {
            Customer customer = exisitingCustomer.get();
            try {
                customerRepository.deleteById(customer.getId());
                cust.setErrDesc("DELETED");
            }catch (Exception ex) {
                cust.setErrDesc(ex.getMessage());
            }
        } else {
            cust.setErrDesc("DATA NOT FOUND");
        }
        return cust;
    }


    public Customer findById(Long id) {
        Optional<Customer> exisitingCustomer =  customerRepository.findById(id);
        if (exisitingCustomer.isPresent()) {
            Customer customer = exisitingCustomer.get();
            customer.setErrDesc("DATA FOUND");
            return customer;
        }
        Customer customer = new Customer();
        customer.setErrDesc("DATA NOT FOUND");
        return customer;
    }

}
