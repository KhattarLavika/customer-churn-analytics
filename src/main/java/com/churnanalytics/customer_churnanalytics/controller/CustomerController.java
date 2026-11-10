
package com.churnanalytics.customer_churnanalytics.controller;

import com.churnanalytics.customer_churnanalytics.dto.CustomerRequest;
import com.churnanalytics.customer_churnanalytics.entity.Customer;
import com.churnanalytics.customer_churnanalytics.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // GET all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    // GET customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    // CREATE customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(
            @Valid @RequestBody CustomerRequest customerRequest) {

        Customer createdCustomer = customerService.createCustomer(customerRequest);

        return ResponseEntity.status(201).body(createdCustomer);
    }

    // UPDATE customer
    @PatchMapping("/{id}")
    public ResponseEntity<Customer> updateMonthlyCharges(
            @PathVariable Long id,
            @RequestBody Map<String, BigDecimal> request) {

        BigDecimal monthlyCharges = request.get("monthlyCharges");

        Customer updatedCustomer = customerService.updateCustomer(id, monthlyCharges);

        return ResponseEntity.ok(updatedCustomer);
    }

    // DELETE customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {

        customerService.deleteCustomer(id);

        return ResponseEntity.noContent().build();
    }
}
