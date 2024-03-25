package com.example.mystore.MyStore.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;
    private String street;
    private String postal_code;




    public Address(Integer id, Integer number, String street, String postal_code) {
        this.id = id;
        this.number = number;
        this.street = street;
        this.postal_code = postal_code;
    }

    public Address(Integer number, String street, String postal_code) {
        this.number = number;
        this.street = street;
        this.postal_code = postal_code;
    }

    public Address() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postal_code;
    }

    public void setPostalCode(String postal_code) {
        this.postal_code = postal_code;
    }
}

