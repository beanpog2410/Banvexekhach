/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.banvexekhach.services;

import com.beanpog.banvexekhach.pojo.Bus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.beanpog.banvexekhach.pojo.Trip;
import java.sql.Date;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGUYENVANTHUONG
 */
public class TripServices {
    
    public static Trip getTripById(int id) throws SQLException {
    Connection conn = Utils.getConn();
    String q = "SELECT * FROM chuyenxe WHERE idChuyenXe=?";
    PreparedStatement stm = conn.prepareStatement(q);
    stm.setInt(1, id);
    ResultSet rs = stm.executeQuery();

    while (rs.next())
        return new Trip(rs.getInt("idChuyenXe"), rs.getInt("idBenkhoihanh")
                , rs.getInt("idBenden"), rs.getDate("Thoigiankhoihanh")
                , rs.getInt("idXe"), rs.getInt("price"));

    return null;
    }
    
    public static List<Trip> getTrip() throws SQLException {
       Connection conn = Utils.getConn();
       Statement stm = conn.createStatement();
       ResultSet rs = stm.executeQuery("SELECT * FROM benxe");

       List<Trip> kq = new ArrayList<>();
       while (rs.next()) {
           int idT = rs.getInt("idChuyenXe");
           int idS = rs.getInt("idBenkhoihanh");
           int idD = rs.getInt("idBenden");
           Date time = rs.getDate("Thoigiankhoihanh");
           int idX = rs.getInt("idXe");
           int price = rs.getInt("price");
           
           Trip c = new Trip(idT, idS, idD, time, idX, price);

           kq.add(c);
       }

       return kq;
   }
    
    
    public static boolean addTrip(int IdStartPlace, int IdDestination, Date time, int idBus, int price) {
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "INSERT INTO chuyenxe( idBenkhoihanh, idBenden, Thoigiankhoihanh, idXe, price) " 
                + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, IdStartPlace);
        stm.setInt(2, IdDestination);
        stm.setDate(3, time);
        stm.setInt(4, idBus);
        stm.setInt(5,price);
        
        stm.executeUpdate();

        conn.commit();

        return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(Trip.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
    }
    
    public static boolean updateTrip( int IdStartPlace, int IdDestination, Date time, int idBus, int price) {
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "UPDATE INTO chuyenxe(idBenkhoihanh, idBenden, Thoigiankhoihanh, idXe, price) " 
                + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, IdStartPlace);
        stm.setInt(2, IdDestination);
        stm.setDate(3, time);
        stm.setInt(4, idBus);
        stm.setInt(5,price);
        
        stm.executeUpdate();

        conn.commit();

        return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(Trip.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
    }
    
    
    public static boolean deleteTrip(int id) {
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "DELETE * FROM chuyenxe WHERE idchuyenXe=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        stm.executeUpdate();

        conn.commit();

        return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(Trip.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
    }
    
    public static List<Bus> Bus_Filter(int idS, int idD, Date time) throws SQLException {
        
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "SELECT * FROM chuyenxe WHERE idBenkhoihanh=? AND idBenden = ? AND Thoigiankhoihanh = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, idS);
        stm.setInt(2, idD);
        stm.setDate(3, time);
        ResultSet rs = stm.executeQuery();
        
        List<Bus> kq = new ArrayList<>();
        while (rs.next()) {
            
           int idX = rs.getInt("idXe");
           Bus b = BusServices.getBusById(idX);
            
           kq.add(b);
        }
        

        conn.commit();
        
        return kq;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(Trip.class.getName()).log(Level.SEVERE, null, ex1);
            } 
        }
        return null;
    }
    
    public static Trip getTripWithoutId(int idSt, int idDe, Date timeS, int idB) throws SQLException{
        
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "SELECT * FROM chuyenxe WHERE idBenkhoihanh=? AND idBenden = ? AND Thoigiankhoihanh = ? AND idXe = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, idSt);
        stm.setInt(2, idDe);
        stm.setDate(3, timeS);
        stm.setInt(4, idB);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()) {
           return new Trip(rs.getInt("idChuyenXe"), rs.getInt("idBenkhoihanh")
                , rs.getInt("idBenden"), rs.getDate("Thoigiankhoihanh")
                , rs.getInt("idXe"), rs.getInt("price"));
        }
        
        conn.commit();

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(Trip.class.getName()).log(Level.SEVERE, null, ex1);
            } 
        }
        return null; 
    }
}
   
        
   
      