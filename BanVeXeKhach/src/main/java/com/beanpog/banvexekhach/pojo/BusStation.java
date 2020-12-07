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
public class BusStation {

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
     * @return the BSName
     */
    public String getBSName() {
        return BSName;
    }

    /**
     * @param BSName the BSName to set
     */
    public void setBSName(String BSName) {
        this.BSName = BSName;
    }
    
    private int id;
    private String BSName;
    
    public BusStation(int id, String BSName)
    {
        this.BSName = BSName;
        this.id = id;
    }
    
    @Override
    public String toString(){
        return this.getBSName();
    }
}
