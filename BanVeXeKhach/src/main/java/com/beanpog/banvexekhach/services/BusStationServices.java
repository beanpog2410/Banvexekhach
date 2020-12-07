/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.banvexekhach.services;

/**
 *
 * @author NGUYENVANTHUONG
 */
import com.beanpog.banvexekhach.pojo.BusStation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BusStationServices {
    
    public static BusStation getBusStationById(int id) throws SQLException {
    Connection conn = Utils.getConn();
    String q = "SELECT * FROM benxe WHERE idBenXe=?";
    PreparedStatement stm = conn.prepareStatement(q);
    stm.setInt(1, id);
    ResultSet rs = stm.executeQuery();

    while (rs.next())
        return new BusStation(rs.getInt("idBenXe"), rs.getString("Ten"));

    return null;
    }
    
    public static BusStation getBusStationByName(String name) throws SQLException {
    Connection conn = Utils.getConn();
    String q = "SELECT * FROM benxe WHERE Ten=?";
    PreparedStatement stm = conn.prepareStatement(q);
    stm.setString(1, name);
    ResultSet rs = stm.executeQuery();

    while (rs.next())
        return new BusStation(rs.getInt("idBenXe"), rs.getString("Ten"));

    return null;
    }
    
    public static List<BusStation> getBusStation() throws SQLException {
       Connection conn = Utils.getConn();
       Statement stm = conn.createStatement();
       ResultSet rs = stm.executeQuery("SELECT * FROM benxe");

       List<BusStation> kq = new ArrayList<>();
       while (rs.next()) {
           int id = rs.getInt("idBenXe");
           String name = rs.getString("Ten");
           BusStation c = new BusStation(id, name);

           kq.add(c);
       }

       return kq;
   }

    public static boolean addBusStation(int id, String BSName) {
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "INSERT INTO benxe(idBenXe, Ten) " 
                + "VALUES(?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        stm.setString(2, BSName);
        stm.executeUpdate();

        conn.commit();

        return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(BusStation.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
    }

    public static boolean updateBusStation(int id, String BSName) {
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "UPDATE INTO benxe(idBenXe, Ten) " 
                + "VALUES(?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        stm.setString(2, BSName);
        stm.executeUpdate();

        conn.commit();

        return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(BusStation.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
    }
    
    public static boolean deleteBusStation(int id) {
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "DELETE * FROM benxe WHERE idBenXe=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        stm.executeUpdate();

        conn.commit();

        return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(BusStation.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
    }
}
