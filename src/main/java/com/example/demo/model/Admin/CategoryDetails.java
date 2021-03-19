package com.example.demo.model.Admin;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoryDetails {
    @NotBlank
    private final String cat_title;
    private final int cat_id;
    public CategoryDetails(@JsonProperty("cat_title") String cat_title,
                           @JsonProperty("cat_id") int cat_id) {
        this.cat_title = cat_title;
        this.cat_id = cat_id;
    }
    public String getCat_title(){
        return cat_title;
    }
    public int getCat_id(){
        return cat_id;
    }
}
