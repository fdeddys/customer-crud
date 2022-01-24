package com.deddy.devtest.controller;


import com.deddy.devtest.model.Customer;
import com.deddy.devtest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "name/{name}")
    Customer getById(@PathVariable("name")String name){

        return customerService.findByName(name);
    }

    @GetMapping(value = "id/{id}")
    Customer getById(@PathVariable("id")Long id){

        return customerService.findById(id);
    }

    @PostMapping
    Customer saveCustomer(@RequestBody Customer customer) {
        return  customerService.save(customer);
    }

    @PutMapping(value = "{name}")
    Customer updateCustomer(@PathVariable("name") String name,
                            @RequestBody Customer customer) {
        return  customerService.update(name, customer);
    }

    @DeleteMapping(value = "{id}")
    Customer deleteCustomer(@PathVariable("id") Long id) {
        return customerService.delete(id);
    }

}
