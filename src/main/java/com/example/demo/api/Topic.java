package com.example.demo.api;

public class Topic {
    private  String id;
    private  String  name;
    private  String Description;

    public Topic(){

    }
    public Topic(String id,String name,String Description){
        super();
        this.id = id;
        this.name = name;
        this.Description = Description;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
