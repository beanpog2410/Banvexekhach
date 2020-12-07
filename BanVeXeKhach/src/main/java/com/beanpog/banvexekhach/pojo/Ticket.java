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
public class Ticket {

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
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the idCus
     */
    public int getIdCus() {
        return idCus;
    }

    /**
     * @param idCus the idCus to set
     */
    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }

    /**
     * @return the idSeat
     */
    public int getIdSeat() {
        return idSeat;
    }

    /**
     * @param idSeat the idSeat to set
     */
    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
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
    
    private int id;
    private int price;
    private int idCus;
    private int idSeat;
    private int idStaff;
    
    public Ticket(int id, int price, int idCus, int idSeat, int idStaff) {
        this.id = id;
        this.price = price;
        this.idCus = idCus;
        this.idSeat = idSeat;
        this.idStaff = idStaff;
    }
    
    public Ticket( int price, int idCus, int idSeat) {
        this.price = price;
        this.idCus = idCus;
        this.idSeat = idSeat;
    }
    
    @Override
    public String toString() {
        return String.valueOf(getId());
    }
}
