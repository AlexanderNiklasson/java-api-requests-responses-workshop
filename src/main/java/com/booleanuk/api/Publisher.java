package com.booleanuk.api;

public class Publisher {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;

    public Publisher(String name, String city){
        this.name = name;
        this.city = city;
    }
}
