package com.example.demo.model.Customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CustomerDetails {
    @NotBlank
    private  String customer_name;
    private  String customer_email;
    private  String customer_contact;
    private  String customer_address;
    private  String customer_password;
    private  String customer_username;

    public CustomerDetails(@JsonProperty("customer_name")String customer_name,@JsonProperty("customer_email") String customer_email,
                           @JsonProperty("customer_contact")String customer_contact, @JsonProperty("customer_address")String customer_address,
                           @JsonProperty("customer_password")String customer_password, @JsonProperty("customer_username")String customer_username){
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.customer_contact = customer_contact;
        this.customer_address = customer_address;
        this.customer_password = customer_password;
        this.customer_username = customer_username;
    }

    public  CustomerDetails(){

    }

    public String getCustomer_name()
    {
        return customer_name;
    }

    public String getCustomer_email()
    {
        return customer_email;
    }
    public String getCustomer_contact()
    {
        return customer_contact;
    }
    public String getCustomer_address()
    {
        return customer_address;
    }
    public String getCustomer_password()
    {
        return customer_password;
    }
    public String getCustomer_username()
    {
        return customer_username;
    }

    // set methods
    public void setCustomer_name(String customer_name){
        this.customer_name = customer_name;
    }
    public void setCustomer_email(String customer_email){
        this.customer_email = customer_email;
    }

    public void setCustomer_contact(String customer_contact)
    {
        this.customer_contact = customer_contact;
    }

    public void setCustomer_address(String customer_address){
        this.customer_address = customer_address;
    }
    public void setCustomer_password(String customer_password)
    {
        this.customer_password = customer_password;
    }
    public void setCustomer_username(String customer_username)
    {
        this.customer_username = customer_username;
    }

}
