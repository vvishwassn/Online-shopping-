package com.tns.onlineshopping.services;
import com.tns.onlineshopping.entities.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerServices {
    private List<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    //retrieve Customer by ID
    public Customer getCustomer(int userId) {
        return customerList.stream()
                .filter(customer -> customer.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    public List<Customer> getCustomers() {
        return customerList;
    }
}