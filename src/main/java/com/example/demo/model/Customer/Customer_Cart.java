package com.example.demo.model.Customer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer_Cart {

    private String customer_username;
    private String seller_username;
    private int product_id;
    private int quantity;

    public Customer_Cart(@JsonProperty("customer_username") String customer_username,
                         @JsonProperty("seller_username") String seller_username,
                         @JsonProperty("product_id") int product_id,
                         @JsonProperty("quantity")int quantity) {
        this.customer_username = customer_username;
        this.seller_username = seller_username;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public Customer_Cart(){

    }

    public String getCustomer_username(){
        return customer_username;
    }
    public String getSeller_username(){
        return seller_username;
    }
    public int getProduct_id(){ return product_id; }
    public int getQuantity(){ return quantity; }

    // set methods

    public void setCustomer_username(String customer_username){
        this.customer_username = customer_username;
    }
    public void setSeller_username(String seller_username){
        this.seller_username  =seller_username;
    }

    public  void setProduct_id(int product_id){
        this.product_id =product_id;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
