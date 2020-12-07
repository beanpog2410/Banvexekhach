/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.banvexekhach.services;

import com.beanpog.banvexekhach.pojo.Seat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGUYENVANTHUONG
 */
public class SeatServices {
    public static Seat getSeatById(int id) throws SQLException {
        Connection conn = Utils.getConn();
        String q = "SELECT * FROM ghe WHERE idGhe=?";
        PreparedStatement stm = conn.prepareStatement(q);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();

        while (rs.next())
            return new Seat(rs.getInt("idGhe"), rs.getString("Ten")
                    , rs.getInt("idChuyenXe"));

        return null;
    }
    
     public static Seat getSeatWithoutId(String name, int idTrip) throws SQLException {
        Connection conn = Utils.getConn();
        String q = "SELECT * FROM ghe WHERE Ten = ? AND idChuyenXe = ?";
        PreparedStatement stm = conn.prepareStatement(q);
        stm.setString(1, name);
        stm.setInt(2, idTrip);
        ResultSet rs = stm.executeQuery();

        while (rs.next())
            return new Seat(rs.getInt("idGhe"), rs.getString("Ten")
                    , rs.getInt("idChuyenXe"));

        return null;
    }
    
    public static List<Seat> getSeat() throws SQLException {
       Connection conn = Utils.getConn();
       Statement stm = conn.createStatement();
       ResultSet rs = stm.executeQuery("SELECT * FROM ghe");

       List<Seat> kq = new ArrayList<>();
       while (rs.next()) {
           int id = rs.getInt("idGhe");
           String name = rs.getString("Ten");
           int idTrip = rs.getInt("idChuyenXe");
           
           Seat c = new Seat(id, name, idTrip);

           kq.add(c);
       }

       return kq;
   }
    
    
    public static boolean addSeat(String name, int idTrip) {
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "INSERT INTO ghe(Ten, idChuyenXe) " 
                + "VALUES(?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, name);
        stm.setInt(2, idTrip);
        
        stm.executeUpdate();

        conn.commit();

        return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(Seat.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
    }
    
    public static boolean updateSeat(String name, int idTrip) {
        Connection conn = Utils.getConn();
        try {

                conn.setAutoCommit(false);
        String sql = "UPDATE INTO ghe(Ten, idChuyenXe) " 
                + "VALUES(?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(2, name);
        stm.setInt(3, idTrip);
        
        stm.executeUpdate();

        conn.commit();

        return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(Seat.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
    }
    
    
    public static boolean deleteSeat(int id) {
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "DELETE * FROM ghe WHERE idGhe=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        stm.executeUpdate();

        conn.commit();

        return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(Seat.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
    }
    
    public static List<Seat> getSeatbyidTrip(int idTrip) throws SQLException {
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "SELECT * FROM ghe WHERE idChuyenXe = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, idTrip);
        ResultSet rs = stm.executeQuery();
        
        List<Seat> kq = new ArrayList<>();
        while (rs.next()) {
           int id = rs.getInt("idGhe");
           String nameS = rs.getString("Ten");
           int idT = rs.getInt("idChuyenXe");
           
           Seat c = new Seat(id, nameS, idT);

           kq.add(c);
        }
        

        conn.commit();
        
        return kq;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(Seat.class.getName()).log(Level.SEVERE, null, ex1);
            } 
        }
        return null;
   }
    
}
