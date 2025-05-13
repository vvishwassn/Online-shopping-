package com.tns.onlineshopping.entities;

	import java.util.ArrayList;
	import java.util.List;

	public class Order {
	    private int orderId;
	    private String status;
	    private Customer customer;
	    private List<ProductQuantityPair> products;

	    public Order(int orderId, Customer customer) {
	        this.orderId = orderId;
	        this.customer = customer;
	        this.status = "Pending"; // Default status
	        this.products = new ArrayList<>();
	    }

	    // Getters and setters
	    public int getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(int orderId) {
	        this.orderId = orderId;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }

	    public List<ProductQuantityPair> getProducts() {
	        return products;
	    }

	    public void addProduct(ProductQuantityPair productQuantityPair) {
	        this.products.add(productQuantityPair);
	    }
	}