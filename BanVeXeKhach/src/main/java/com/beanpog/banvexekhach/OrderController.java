/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.banvexekhach;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import com.beanpog.banvexekhach.pojo.Bus;
import com.beanpog.banvexekhach.services.BusServices;
import java.sql.SQLException;







/**
 * FXML Controller class
 *
 * @author NGUYENVANTHUONG
 */
public class OrderController implements Initializable {

    @FXML
    private ComboBox<Bus> cbBus;
    @FXML
    private ComboBox cbStart;
    @FXML
    private ComboBox cbDestination;
    @FXML
    private ComboBox cbSeat;
    @FXML
    private Label lbPrice;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private Button btSubmit;
    @FXML
    private Button btSeat;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbBus.getItems().addAll(BusServices.getBus());
        } catch (SQLException ex) {
            System.err.print("Sai roi");
        }
    }    
    
}
