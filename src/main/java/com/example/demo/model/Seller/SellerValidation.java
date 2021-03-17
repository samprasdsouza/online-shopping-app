package com.example.demo.model.Seller;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SellerValidation {
    @NotBlank
    private final String seller_username;
    private final String seller_password;

    public SellerValidation(@JsonProperty("seller_username") String seller_username, @JsonProperty("seller_password")String seller_password) {
        this.seller_username = seller_username;
        this.seller_password = seller_password;
    }
    public String getSeller_username(){
        return seller_username;
    }
    public String getSeller_password(){
        return seller_password;
    }
}
