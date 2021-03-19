package com.example.demo.model.Admin;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
public class BrandDetails {
    @NotBlank
    private final String brand_title;
    private final  int brand_id;

    public BrandDetails(@JsonProperty("brand_title") String brand_title,
                        @JsonProperty("brand_id")int brand_id) {
        this.brand_title = brand_title;
        this.brand_id = brand_id;
    }


    public String getBrand_title(){
        return brand_title;
    }

    public int getBrand_id(){
        return brand_id;
    }
}
