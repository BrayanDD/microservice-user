package com.example.user.domain.model;

public class Roles {

    private Long id;
    private String name;

    

    public Roles(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Roles() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


   
}