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
public class User {
    
    private int id;
    private String username;
    private String password;
    private int idStaff;

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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the idStaff
     */
    public int getIdStaff() {
        return idStaff;
    }

    /**
     * @param idStaff the idStaff to set
     */
    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }
    
    public User(int id, String username, String password, int idStaff) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.idStaff = idStaff;
    }
    
    public User(String username, String password, int idStaff) {
        this.username = username;
        this.password = password;
        this.idStaff = idStaff;
    }
     
    @Override
    public String toString() {
        return this.getUsername();
    }

    
    
}
