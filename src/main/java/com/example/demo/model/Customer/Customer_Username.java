package com.example.demo.model.Customer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer_Username {
    public final String customer_username;

    public Customer_Username(@JsonProperty("customer_username") String customer_username) {
        this.customer_username = customer_username;
    }

    public String getCustomer_username(){
        return customer_username;
    }
}
