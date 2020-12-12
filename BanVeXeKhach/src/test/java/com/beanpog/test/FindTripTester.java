/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.test;

import com.beanpog.banvexekhach.pojo.Bus;
import com.beanpog.banvexekhach.services.TripServices;
import com.beanpog.banvexekhach.services.Utils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author NGUYENVANTHUONG
 */
public class FindTripTester {
    
    private static Connection conn;

    
    @BeforeAll
    public static void setUpClass() {
        conn = Utils.getConn();
    }
    
    @AfterAll
    public static void tearDownClass() {
         try {
            Utils.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test               
    public void testFindListBus1() throws SQLException {
        Date d = Date.valueOf("2020-12-10");
        List<Bus> b = TripServices.Bus_Filter(1, 2, d);
        
        assertEquals(1, b.size());
    }
    
    @Test               
    public void testFindListBus2() throws SQLException {
        Date d = Date.valueOf("2020-12-11");
        List<Bus> b = TripServices.Bus_Filter(2, 1, d);
        
        assertEquals(1, b.size());
    }
    
    @Test               
    public void testFindNoListBus() throws SQLException {
        Date d = Date.valueOf("2020-12-11");
        List<Bus> b = TripServices.Bus_Filter(1, 2, d);
        
        assertEquals(0, b.size());
    }

}
