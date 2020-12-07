/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.banvexekhach.pojo;

/**
 *
 * @author NGUYENVANTHUONG
 */
public class Customer {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    
    public Customer(int id, String fName, String lName, String phoneN) {
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.phoneNumber = phoneN;
    }
    
    public Customer(String fName, String lName, String phoneN) {
        this.firstName = fName;
        this.lastName = lName;
        this.phoneNumber = phoneN;
    }
    
    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }
    
}
