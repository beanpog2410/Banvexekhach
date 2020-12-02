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
}

