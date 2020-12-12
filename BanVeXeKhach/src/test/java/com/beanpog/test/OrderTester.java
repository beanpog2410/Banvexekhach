/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.test;

import com.beanpog.banvexekhach.services.TicketServices;
import com.beanpog.banvexekhach.services.Utils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author NGUYENVANTHUONG
 */
public class OrderTester {
    
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
    public void testOrderTicketSuccessful() {
        assertTrue(TicketServices.addTicket(5000, 1, 1));
    }
    
    @Test
    public void testOrderTicketFailed() {
        assertFalse(TicketServices.addTicket(5000, 10, 10));
    }
    
}
