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
import com.beanpog.banvexekhach.pojo.BusStation;
import com.beanpog.banvexekhach.pojo.Bus;
import com.beanpog.banvexekhach.services.BusStationServices;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Trip {

    /**
     * @return the IdStartPlace
     */
    public int getIdStartPlace() {
        return IdStartPlace;
    }

    /**
     * @param IdStartPlace the IdStartPlace to set
     */
    public void setIdStartPlace(int IdStartPlace) {
        this.IdStartPlace = IdStartPlace;
    }

    /**
     * @return the IdDestination
     */
    public int getIdDestination() {
        return IdDestination;
    }

    /**
     * @param IdDestination the IdDestination to set
     */
    public void setIdDestination(int IdDestination) {
        this.IdDestination = IdDestination;
    }

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
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * @return the idBus
     */
    public int getIdBus() {
        return idBus;
    }

    /**
     * @param idBus the idBus to set
     */
    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }
    
    private int id;
    private int IdStartPlace;
    private int IdDestination;
    private Date time;
    private int idBus;
    private int price;
    
    public Trip(int id, int IdStartPlace, int IdDestination, Date time, int idBus, int price)
    {
        this.id = id;
        this.IdStartPlace = IdStartPlace;
        this.IdDestination = IdDestination;
        this.time = time;
        this.idBus = idBus;
        this.price = price;
    }
    
    
    @Override
    public String toString() {
        try {
            String sName = BusStationServices.getBusStationById(IdStartPlace).toString();
            String dName = BusStationServices.getBusStationById(IdDestination).toString();
            
            return sName + " ==> " + dName;
        } catch (SQLException ex) {
            Logger.getLogger(Trip.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
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
  
}
