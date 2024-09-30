package com.incedo.library;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private String address;
    private List<Book> borrowed;
    public Customer(String customerName, String address) {
        this.customerName = customerName;
        this.address = address;
        this.borrowed = new ArrayList<>();
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getAddress() {
        return address;
    }
    public List<Book> getBorrowed() {
        return borrowed;
    }
    public void borrowBook(Book b) {
        borrowed.add(b);
        System.out.println(customerName + " borrowed: " + b);
    }
    public void returnBook(Book b) {
        borrowed.remove(b);
        System.out.println(customerName + " returned: " + b);
    }
}