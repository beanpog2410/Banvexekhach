/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.banvexekhach.services;

import com.beanpog.banvexekhach.pojo.Customer;
import java.sql.Connection;
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
public class CustomerServices {
     public static Customer getCustomerById(int id) throws SQLException {
        Connection conn = Utils.getConn();
        String q = "SELECT * FROM khachhang WHERE id=?";
        PreparedStatement stm = conn.prepareStatement(q);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next())
            return new Customer(rs.getInt("id"), rs.getString("Ho"), rs.getString("Ten"), rs.getString("Sdt"));
        
        return null;
     }
     
     public static Customer getCustomerWithoutId(String fName, String lName, String sdt) throws SQLException {
        Connection conn = Utils.getConn();
        String q = "SELECT * FROM khachhang WHERE Ho = ? AND Ten = ? AND Sdt = ?";
        PreparedStatement stm = conn.prepareStatement(q);
        stm.setString(1, fName);
        stm.setString(2, lName);
        stm.setString(3, sdt);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next())
            return new Customer(rs.getInt("id"), rs.getString("Ho"), rs.getString("Ten"), rs.getString("Sdt"));
        
        return null;
     }
     
     public static List<Customer> getCustomer() throws SQLException {
        Connection conn = Utils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM xe");
        
        List<Customer> kq = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String fName = rs.getString("Ho");
            String lName = rs.getString("Ten");
            String sdt = rs.getString("Sdt");
            
            Customer c = new Customer(id, fName, lName, sdt);
            kq.add(c);
        }
        
        return kq;
    }
     
     public static boolean addCustomer(String fName, String lName, String sdt) {
         Connection conn = Utils.getConn();
         try {
         
         conn.setAutoCommit(false);
         String sql = "INSERT INTO khachhang(Ho, Ten, Sdt) " + 
                 "VALUES(?, ?, ?)";
         PreparedStatement stm = conn.prepareStatement(sql);
         stm.setString(1, fName);
         stm.setString(2, lName);
         stm.setString(3, sdt);
         
         stm.executeUpdate();
         
         conn.commit();
         
         return true;
         
         } catch (SQLException ex) {
             try {
                 conn.rollback();
             }  catch (SQLException ex1) {
                 Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex1);
             }
                 
         }
         return false;
     }
     
     public static boolean updateCustomer(String fName, String lName, String sdt) {
         Connection conn = Utils.getConn();
         try {
         
         conn.setAutoCommit(false);
         String sql = "UPDATE INTO khachhang(Ho, Ten, Sdt) " 
                 + "VALUES(?, ?, ?)";
         PreparedStatement stm = conn.prepareStatement(sql);
         stm.setString(1, fName);
         stm.setString(2, lName);
         stm.setString(3, sdt);
         
         stm.executeUpdate();
         
         conn.commit();
         
         return true;
         
         } catch (SQLException ex) {
             try {
                 conn.rollback();
             }  catch (SQLException ex1) {
                 Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex1);
             }
                 
         }
         return false;
     }
     
    public static boolean deleteCustomer(int id) {
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
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
        }
}
