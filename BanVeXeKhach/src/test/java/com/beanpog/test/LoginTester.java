/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.test;

import com.beanpog.banvexekhach.services.UserServices;
import com.beanpog.banvexekhach.services.Utils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author NGUYENVANTHUONG
 */
public class LoginTester {
    
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
    public void testLoginWithNoUsername() throws SQLException {
        String username = "";
        String password = "123";
        assertFalse(UserServices.CheckUser(username, password));
    }
    
    @Test
    public void testLoginWithNoPassword() throws SQLException {
        String username = "ad";
        String password = "";
        assertFalse(UserServices.CheckUser(username, password));
    }
    
    @Test
    public void testLoginSuccessful() throws SQLException {
        String username = "ad";
        String password = "123";
        assertTrue(UserServices.CheckUser(username, password));
    }
    
    @Test
    public void testLoginWithWrongUsername() throws SQLException {
        String username = "adm";
        String password = "123";
        assertFalse(UserServices.CheckUser(username, password));
    }
    
    @Test
    public void testLoginWithWrongPassword() throws SQLException {
        String username = "ad";
        String password = "1234";
        assertFalse(UserServices.CheckUser(username, password));
    }
    
    @Test
    public void testLoginWithNoPassAndUsername() throws SQLException {
        String username = "";
        String password = "";
        assertFalse(UserServices.CheckUser(username, password));
    }
    
    
}
