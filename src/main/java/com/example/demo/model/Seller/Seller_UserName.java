package com.example.demo.model.Seller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Seller_UserName {
    private final String seller_username;

    public Seller_UserName(@JsonProperty("seller_username") String seller_username) {
        this.seller_username = seller_username;
    }

    public String getSeller_username(){
        return seller_username;
    }
}
