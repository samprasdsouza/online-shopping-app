package com.example.demo.model.Product;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product_Details {
    private final String product_name;
    private final String seller_username;

    public Product_Details(@JsonProperty("product_name")String product_name,
                           @JsonProperty("seller_username")String seller_username) {
        this.product_name = product_name;
        this.seller_username = seller_username;
    }
    public String getProduct_name(){
        return product_name;
    }
    public String getSeller_username(){
        return seller_username;
    }
}
