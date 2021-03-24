package com.example.demo.model.Seller;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SellerProductUpdate {
    private final String seller_username;
    private final int product_price;
    private final String product_image_path;

    public SellerProductUpdate(@JsonProperty("seller_username") String seller_username, @JsonProperty("product_price") int product_price,
                               @JsonProperty("product_image_path") String product_image_path) {
        this.seller_username = seller_username;
        this.product_price = product_price;
        this.product_image_path = product_image_path;
    }


    public String seller_username() {
        return seller_username;
    }

    public String getProduct_image_path(){
        return  product_image_path;
    }

    public int getProduct_price(){
        return product_price;
    }

}
