/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.banvexekhach.services;

import com.beanpog.banvexekhach.pojo.User;
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
public class UserServices {
    
    public static User getUserById(int id) throws SQLException {
        Connection conn = Utils.getConn();
        String q = "SELECT * FROM user WHERE id=?";
        PreparedStatement stm = conn.prepareStatement(q);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next())
            return new User(rs.getString("username"), rs.getString("password"), rs.getInt("idStaff"));
        
        return null;
     }
    
    public static User getUserWithoutId(String username, String password) throws SQLException {
        Connection conn = Utils.getConn();
        String q = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement stm = conn.prepareStatement(q);
        stm.setString(1, username);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next())
            return new User(rs.getString("username"), rs.getString("password"), rs.getInt("idStaff"));
        
        return null;
    }
    
    
    public static boolean CheckUser(String username, String password) throws SQLException {
        Connection conn = Utils.getConn();
        String q = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement stm = conn.prepareStatement(q);
        stm.setString(1, username);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next())
            return true;
        
        return false;
     }
    
    
     public static List<User> getUser() throws SQLException {
        Connection conn = Utils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM xe");
        
        List<User> kq = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("pasword");
            int idStaff = rs.getInt("idStaff");
            
            User c = new User(id, username, password, idStaff);
            
            kq.add(c);
        }
        
        return kq;
    }
     
     public static boolean addUser(String username, String password, int idStaff) {
         Connection conn = Utils.getConn();
         try {
         
         conn.setAutoCommit(false);
         String sql = "INSERT INTO user(username, password, idStaff) " 
                 + "VALUES(?, ?, ?)";
         PreparedStatement stm = conn.prepareStatement(sql);
         stm.setString(1, username);
         stm.setString(2, password);
         stm.setInt(3, idStaff);
         
         stm.executeUpdate();
         
         conn.commit();
         
         return true;
         
         } catch (SQLException ex) {
             try {
                 conn.rollback();
             }  catch (SQLException ex1) {
                 Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex1);
             }
                 
         }
         return false;
     }
     
     public static boolean updateUser(String username, String password, int idStaff) {
         Connection conn = Utils.getConn();
         try {
         
         conn.setAutoCommit(false);
        String sql = "UPDATE INTO user(username, password, idStaff) " 
                 + "VALUES(?, ?, ?)";
         PreparedStatement stm = conn.prepareStatement(sql);
         stm.setString(1, username);
         stm.setString(2, password);
         stm.setInt(3, idStaff);
         
         stm.executeUpdate();
         
         conn.commit();
         
         return true;
         
         } catch (SQLException ex) {
             try {
                 conn.rollback();
             }  catch (SQLException ex1) {
                 Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex1);
             }
                 
         }
         return false;
     }
     
    public static boolean deleteUser(int id) {
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "DELETEs * FROM xe WHERE id=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        stm.executeUpdate();

        conn.commit();

        return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
        }
    
}
