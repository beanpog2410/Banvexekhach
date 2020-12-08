/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.banvexekhach.pojo;

import java.sql.Date;

/**
 *
 * @author NGUYENVANTHUONG
 */
public class TicketView {

    /**
     * @return the ticket
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * @param ticket the ticket to set
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * @return the trip
     */
    public Trip getTrip() {
        return trip;
    }

    /**
     * @param trip the trip to set
     */
    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    /**
     * @return the cus
     */
    public Customer getCus() {
        return cus;
    }

    /**
     * @param cus the cus to set
     */
    public void setCus(Customer cus) {
        this.cus = cus;
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
    private Ticket ticket;
    private Trip trip;
    private Customer cus;
    private Date time;
    
    public TicketView(Ticket ticket, Trip trip, Customer cus, Date time) {
        this.ticket = ticket;
        this.trip = trip;
        this.cus = cus;
        this.time = time;
    }
    
}
