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
public class Seat {

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
     * @return the idTrip
     */
    public int getIdTrip() {
        return idTrip;
    }

    /**
     * @param idTrip the idTrip to set
     */
    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    private int id;
    private int idTrip;
    private String name;

    
    public Seat(int id, String name, int idTrip){
        this.id = id;
        this.name = name;
        this.idTrip = idTrip;
    }
    
    public Seat(String name, int idTrip){
        this.name = name;
        this.idTrip = idTrip;
    }
    
    
    @Override
    public String toString(){
        return this.getName();
    }
}
