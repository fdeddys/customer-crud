package com.deddy.devtest.repo;

import com.deddy.devtest.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository  extends JpaRepository<Customer, Long > {

    Optional<Customer> findByName(String name);
}
