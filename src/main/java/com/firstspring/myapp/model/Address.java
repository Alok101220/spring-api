package com.firstspring.myapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private int add_id;
    private String city;
    private String state;
    private int pinCode;
    public int getId() {
        return add_id;
    }
    public void setId(int id) {
        this.add_id = id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getPinCode() {
        return pinCode;
    }
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
    

    
}
