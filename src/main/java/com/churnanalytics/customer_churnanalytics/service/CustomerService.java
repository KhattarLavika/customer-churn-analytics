
package com.churnanalytics.customer_churnanalytics.service;

import com.churnanalytics.customer_churnanalytics.dto.CustomerRequest;
import com.churnanalytics.customer_churnanalytics.entity.Customer;
import com.churnanalytics.customer_churnanalytics.repository.CustomerRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Create customer
    public Customer createCustomer(CustomerRequest customerRequest) {

        Customer customer=new Customer();

        // Convert CustomerRequest into Customer
        customer.setCustomerId(customerRequest.getCustomerId());
        customer.setGender(customerRequest.getGender());
        customer.setSeniorCitizen(customerRequest.isSeniorCitizen());
        customer.setPartner(customerRequest.isPartner());
        customer.setDependents(customerRequest.isDependents());
        customer.setTenure(customerRequest.getTenure());

        customer.setPhoneService(customerRequest.isPhoneService());
        customer.setMultipleLines(customerRequest.getMultipleLines());
        customer.setInternetService(customerRequest.getInternetService());
        customer.setOnlineSecurity(customerRequest.getOnlineSecurity());
        customer.setOnlineBackup(customerRequest.getOnlineBackup());
        customer.setDeviceProtection(customerRequest.getDeviceProtection());
        customer.setTechSupport(customerRequest.getTechSupport());
        customer.setStreamingTV(customerRequest.getStreamingTV());
        customer.setStreamingMovies(customerRequest.getStreamingMovies());

        customer.setContract(customerRequest.getContract());
        customer.setPaperlessBilling(customerRequest.isPaperlessBilling());
        customer.setPaymentMethod(customerRequest.getPaymentMethod());

        customer.setMonthlyCharges(customerRequest.getMonthlyCharges());
        customer.setTotalCharges(customerRequest.getTotalCharges());
        customer.setChurn(customerRequest.isChurn());

        return customerRepository.save(customer);
    }

    // Retrieve all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Retrieve customer by ID
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found with ID: " + id));
    }

    // Update customer
    public Customer updateCustomer(Long id, BigDecimal monthlyCharges) {

        Customer customer=getCustomerById(id);

        customer.setMonthlyCharges(monthlyCharges);
        int rowsUpdated = customerRepository.updateMonthlyCharges(id, monthlyCharges);

        if (rowsUpdated != 1) {
            throw new RuntimeException("Customer could not be updated");
        }

        return customer;
    }

    // Delete customer
    public void deleteCustomer(Long id) {

        getCustomerById(id);

        int rowsDeleted = customerRepository.deleteById(id);

        if (rowsDeleted != 1) {
            throw new RuntimeException("Customer could not be deleted");
        }
    }
}
