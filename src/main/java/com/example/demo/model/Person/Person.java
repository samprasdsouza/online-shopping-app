package com.example.demo.model.Person;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {
    private  UUID id;

    @NotBlank
    private String name;
    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
    public Person(){

    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name =name;
    }

    public void setid(long id) {
        //this.id = (UUID)id;
    }
}
