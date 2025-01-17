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

import com.beanpog.banvexekhach.pojo.Bus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
        
        
        
public class BusServices {
     public static Bus getBusById(int id) throws SQLException {
        Connection conn = Utils.getConn();
        String q = "SELECT * FROM xe WHERE idXe=?";
        PreparedStatement stm = conn.prepareStatement(q);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next())
            return new Bus(rs.getInt("idXe"), rs.getString("Biensoxe"));
        
        return null;
     }
     public static List<Bus> getBus() throws SQLException {
        Connection conn = Utils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM xe");
        
        List<Bus> kq = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("idXe");
            String bienSo = rs.getString("Biensoxe");
            Bus c = new Bus(id, bienSo);
            
            kq.add(c);
        }
        
        return kq;
    }
     
     public static boolean addBus(int id, String bienSo) {
         Connection conn = Utils.getConn();
         try {
         
         conn.setAutoCommit(false);
         String sql = "INSERT INTO xe(idXe, Biensoxe) " 
                 + "VALUES(?, ?)";
         PreparedStatement stm = conn.prepareStatement(sql);
         stm.setInt(1, id);
         stm.setString(2, bienSo);
         stm.executeUpdate();
         
         conn.commit();
         
         return true;
         
         } catch (SQLException ex) {
             try {
                 conn.rollback();
             }  catch (SQLException ex1) {
                 Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex1);
             }
                 
         }
         return false;
     }
     
     public static boolean updateBus(int id, String bienSo) {
         Connection conn = Utils.getConn();
         try {
         
         conn.setAutoCommit(false);
         String sql = "UPDATE INTO xe(idXe, Biensoxe) " 
                 + "VALUES(?, ?)\"";
         PreparedStatement stm = conn.prepareStatement(sql);
         stm.setInt(1, id);
         stm.setString(2, bienSo);
         stm.executeUpdate();
         
         conn.commit();
         
         return true;
         
         } catch (SQLException ex) {
             try {
                 conn.rollback();
             }  catch (SQLException ex1) {
                 Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex1);
             }
                 
         }
         return false;
     }
     
    public static boolean deleteBus(int id) {
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "DELETEs * FROM xe WHERE idXe=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        stm.executeUpdate();

        conn.commit();

        return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
        }
}

