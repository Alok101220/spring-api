package com.firstspring.myapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int auth_id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public int getId() {
        return this.auth_id;
    }

    public void setId(int id) {
        this.auth_id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}
