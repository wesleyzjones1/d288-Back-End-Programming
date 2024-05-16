package com.d288.Vacation.bootstrap;

import com.d288.Vacation.dao.CartItemRepository;
import com.d288.Vacation.dao.CustomerRepository;
import com.d288.Vacation.dao.DivisionRepository;
import com.d288.Vacation.dao.ExcursionRepository;
import com.d288.Vacation.entities.Customer;
import com.d288.Vacation.entities.Division;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BootstrapData{

    private final CustomerRepository customerRepository;
    private final CartItemRepository cartItemRepository;
    private final ExcursionRepository excursionRepository;
    private final DivisionRepository divisionRepository;

    @Autowired
    public BootstrapData(CustomerRepository customerRepository, CartItemRepository cartItemRepository,
                         ExcursionRepository excursionRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
        this.excursionRepository = excursionRepository;
        this.divisionRepository = divisionRepository;
    }

    @PostConstruct
    public void loadInitialData() {

        if (customerRepository.count() == 1) {
            Set<Customer> customersToAdd = new HashSet<>(customerRepository.findAll());
            List<String> firstNames = List.of("Wesley", "Skyler", "Audrey", "Gabrielle", "Tim", "Misty");
            while (customersToAdd.size() < 6) {
                String firstName = firstNames.get(customersToAdd.size());
                Customer c = new Customer();
                c.setFirstName(firstName);
                c.setLastName("Jones");
                c.setPhone("1234567890");
                c.setAddress("123 Simi Rd");
                c.setPostal_code("12345");
                Set<Division> divisions = new HashSet<>(divisionRepository.findAll());
                if (!divisions.isEmpty()) {
                    c.setDivision(divisions.iterator().next());
                }
                customersToAdd.add(c);
                customerRepository.save(c);
                System.out.println("customer added");
            }
        } else {
            System.out.println("customers exist");
        }
    }
}