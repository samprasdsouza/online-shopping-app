package com.example.demo.model.Admin;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class ProductDetails {

    private final int product_id;
    private final String product_category;
    private final String product_brand;
    private final String product_description;

    public ProductDetails(@JsonProperty("product_id") int product_id,@JsonProperty("product_category")  String product_category,
                          @JsonProperty("product_brand")  String product_brand, @JsonProperty("product_description") String product_description) {
        this.product_id = product_id;
        this.product_category = product_category;
        this.product_brand = product_brand;
        this.product_description = product_description;
    }
    //
    public int getProduct_id(){
        return product_id;
    }
    public  String getProduct_category(){
        return product_category;
    }
    public String getProduct_brand(){
        return product_brand;
    }
    public String getProduct_description(){
        return product_description;
    }
}
