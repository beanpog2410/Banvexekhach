/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beanpog.banvexekhach;

import com.beanpog.banvexekhach.pojo.Ticket;
import com.beanpog.banvexekhach.pojo.TicketView;
import com.beanpog.banvexekhach.services.TicketServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author NGUYENVANTHUONG
 */
public class ManageticketController implements Initializable {

    @FXML
    private TableView<TicketView> tbTicket;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btSearch;
    
    @Override   
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            loadTicket();
            loadData("");
        } catch (SQLException ex) {
            Logger.getLogger(ManageticketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void loadTicket() {
        
        TableColumn colIdTicket = new TableColumn("TicketID");
        colIdTicket.setCellValueFactory(new PropertyValueFactory("ticket"));
        
        TableColumn colTrip = new TableColumn("Chuyến");
        colIdTicket.setCellValueFactory(new PropertyValueFactory("trip"));
        
        TableColumn colCus = new TableColumn("Khách hàng");
        colIdTicket.setCellValueFactory(new PropertyValueFactory("cus"));
        
        TableColumn colTime = new TableColumn("Ngay khoi hanh");
        colIdTicket.setCellValueFactory(new PropertyValueFactory("time"));
        
        tbTicket.getColumns().addAll(colIdTicket, colTrip, colCus, colTime);
    }
    
    private void loadData(String kw) throws SQLException {
        tbTicket.getItems().clear();
        tbTicket.setItems(FXCollections.observableArrayList(TicketServices.getTicketView(kw)));
    }
    
}
