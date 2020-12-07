/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.banvexekhach.services;

import com.beanpog.banvexekhach.pojo.Ticket;
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
public class TicketServices {
    
     public static Ticket getTicketById(int id) throws SQLException {
        Connection conn = Utils.getConn();
        String q = "SELECT * FROM ve WHERE idVe=?";
        PreparedStatement stm = conn.prepareStatement(q);
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next())
            return new Ticket(rs.getInt("idVe"), rs.getInt("price")
                    , rs.getInt("idKhachHang"), rs.getInt("idGhe")
                    , rs.getInt("idNhanVien"));
        
        return null;
     }
     public static List<Ticket> getTicket() throws SQLException {
        Connection conn = Utils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM ve");
        
        List<Ticket> kq = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("idVe");
            int price = rs.getInt("price");
            int idCus = rs.getInt("idKhachHang");
            int idSeat = rs.getInt("idGhe");
            int idStaff = rs.getInt("idNhanVien");
            
            
            Ticket c = new Ticket(id, price, idCus, idSeat, idStaff);
            kq.add(c);
        }
        
        return kq;
    }
     
     public static boolean addTicket(int price, int idCus,int  idSeat) {
         Connection conn = Utils.getConn();
         try {
         
         conn.setAutoCommit(false);
         String sql = "INSERT INTO ve(price, idKhachHang, idGhe) " + "VALUES(?, ?, ?)";
         PreparedStatement stm = conn.prepareStatement(sql);
         stm.setInt(1, price);
         stm.setInt(2, idCus);
         stm.setInt(3, idSeat);
         
         stm.executeUpdate();
         
         conn.commit();
         
         return true;
         
         } catch (SQLException ex) {
             try {
                 conn.rollback();
             }  catch (SQLException ex1) {
                 Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex1);
             }
                 
         }
         return false;
     }
     
     public static boolean updateTicket(int id, int price, int idCus,int  idSeat, int idStaff) {
         Connection conn = Utils.getConn();
         try {
         
         conn.setAutoCommit(false);
        String sql = "UPDATE INTO ve(idVe, price, idKhachHang, idGhe, idNhanVien) " 
                + "VALUES(?, ?, ?, ?, ?)";
         PreparedStatement stm = conn.prepareStatement(sql);
         stm.setInt(1, id);
         stm.setInt(2, price);
         stm.setInt(3, idCus);
         stm.setInt(4, idSeat);
         stm.setInt(5, idStaff);
         ;
         stm.executeUpdate();
         
         conn.commit();
         
         return true;
         
         } catch (SQLException ex) {
             try {
                 conn.rollback();
             }  catch (SQLException ex1) {
                 Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex1);
             }
                 
         }
         return false;
     }
     
    public static boolean deleteTicket(int id) {
        Connection conn = Utils.getConn();
        try {

        conn.setAutoCommit(false);
        String sql = "DELETEs * FROM ve WHERE idVe=?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, id);
        stm.executeUpdate();

        conn.commit();

        return true;

        } catch (SQLException ex) {
            try {
                conn.rollback();
            }  catch (SQLException ex1) {
                Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return false;
        }
    
}
