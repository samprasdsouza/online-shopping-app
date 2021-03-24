package com.example.demo.model.Seller;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SellerProduct {
    private final int seller_product_id;
    private final int seller_id;
    private final int product_id;
    private final int product_price;
    private final String product_image_path;


    public SellerProduct(@JsonProperty("seller_product_id")int seller_product_id, @JsonProperty("seller_id")int seller_id,
                         @JsonProperty("product_id") int product_id, @JsonProperty("product_price")int product_price,
                         @JsonProperty("product_image_path") String product_image_path) {
        this.seller_product_id = seller_product_id;
        this.seller_id = seller_id;
        this.product_id = product_id;
        this.product_price = product_price;
        this.product_image_path = product_image_path;
    }
    public  int getSellerProductId() { return seller_product_id; }
    public int getProduct_id(){return product_id;}
    public int getSeller_id(){return seller_id;}
    public int getProduct_price(){return product_price;}
    public String getProduct_image_path(){return product_image_path;}
}
