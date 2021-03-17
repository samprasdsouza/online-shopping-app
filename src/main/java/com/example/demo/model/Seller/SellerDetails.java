package com.example.demo.model.Seller;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SellerDetails {
    @NotBlank
    private final String seller_name;
    private final String seller_email;
    private final String seller_contact;
    private final String seller_address;
    private final String seller_password;
    private final String seller_username;
    public SellerDetails(@JsonProperty("seller_name") String seller_name, @JsonProperty("seller_email") String seller_email,
                         @JsonProperty("seller_contact") String seller_contact, @JsonProperty("seller_address") String seller_address,
                         @JsonProperty("seller_password") String seller_password,@JsonProperty("seller_username") String seller_username) {
        this.seller_name = seller_name;
        this.seller_email = seller_email;
        this.seller_contact = seller_contact;
        this.seller_address = seller_address;
        this.seller_password = seller_password;
        this.seller_username = seller_username;
    }

    public String getSeller_name(){
        return seller_name;
    }
    public String getSeller_email(){
        return seller_email;
    }
    public String getSeller_contact(){
        return seller_contact;
    }
    public String getSeller_username(){
        return seller_username;
    }

    public String getSeller_password(){
        return seller_password;
    }

    public String getSeller_address() {
        return seller_address;
    }
}
