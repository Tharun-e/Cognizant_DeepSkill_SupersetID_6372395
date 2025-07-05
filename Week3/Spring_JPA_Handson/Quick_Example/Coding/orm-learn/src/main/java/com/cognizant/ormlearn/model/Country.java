package com.cognizant.ormlearn.model;
import jakarta.persistence.*;


@Entity
public class Country {
    @Id
    private String code;
    private String name;

    // Getters and Setters

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
