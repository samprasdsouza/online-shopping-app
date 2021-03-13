package com.example.demo.model.Customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CustomerValidation {
    @NotBlank
    private final String customer_username;
    private final String customer_password;

    public CustomerValidation(@JsonProperty("customer_username") String customer_username, @JsonProperty("customer_password")String customer_password) {
        this.customer_username = customer_username;
        this.customer_password = customer_password;
    }
    public String getCustomer_password()
    {
        return customer_password;
    }
    public String getCustomer_username()
    {
        return customer_username;
    }
}
