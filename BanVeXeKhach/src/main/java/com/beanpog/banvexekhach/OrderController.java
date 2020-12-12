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
import com.beanpog.banvexekhach.services.BusStationServices;
import com.beanpog.banvexekhach.FindTripController;
import com.beanpog.banvexekhach.pojo.BusStation;
import com.beanpog.banvexekhach.pojo.Seat;
import com.beanpog.banvexekhach.services.CustomerServices;
import com.beanpog.banvexekhach.services.SeatServices;
import com.beanpog.banvexekhach.services.TicketServices;
import com.beanpog.banvexekhach.services.TripServices;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;







/**
 * FXML Controller class
 *
 * @author NGUYENVANTHUONG
 */
public class OrderController implements Initializable {

    @FXML
    private ComboBox<Bus> cbBus;
    @FXML
    private Label lbSeat;
    @FXML
    private Label lbStart;
    @FXML
    private Label lbDestination;
    @FXML
    private Label lbTime;
    @FXML
    private Label lbPrice;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPhoneNumber;
    @FXML
    private Button btConfirm;
    @FXML
    private Button btSeatA1;
    @FXML
    private Button btSeatA2;
    @FXML
    private Button btSeatA3;
    @FXML
    private Button btSeatA4;
    @FXML
    private Button btSeatA5;
    @FXML
    private Button btSeatA6;
    @FXML
    private Button btSeatA7;
    @FXML
    private Button btSeatA8;
    @FXML
    private Button btSeatB1;
    @FXML
    private Button btSeatB2;
    @FXML
    private Button btSeatB3;
    @FXML
    private Button btSeatB4;
    @FXML
    private Button btSeatB5;
    @FXML
    private Button btSeatB6;
    @FXML
    private Button btSeatB7;
    @FXML
    private Button btSeatB8;
    @FXML
    private Button btSeatC1;
    @FXML
    private Button btSeatC2;
    @FXML
    private Button btSeatC3;
    @FXML
    private Button btSeatC4;
    @FXML
    private Button btSeatC5;
    @FXML
    private Button btSeatC6;
    @FXML
    private Button btSeatC7;
    @FXML
    private Button btSeatC8;
    @FXML
    private Button btSeatD1;
    @FXML
    private Button btSeatD2;
    @FXML
    private Button btSeatD3;
    @FXML
    private Button btSeatD4;
    @FXML
    private Button btSeatD5;
    @FXML
    private Button btSeatD6;
    @FXML
    private Button btSeatD7;
    @FXML
    private Button btSeatD8;
    

    public List<Button> listSeat = new ArrayList<>();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.listSeat.add(btSeatA1);
        this.listSeat.add(btSeatA2);
        this.listSeat.add(btSeatA3);
        this.listSeat.add(btSeatA4);
        this.listSeat.add(btSeatA5);
        this.listSeat.add(btSeatA6);
        this.listSeat.add(btSeatA7);
        this.listSeat.add(btSeatA8);
        this.listSeat.add(btSeatB1);
        this.listSeat.add(btSeatB2);
        this.listSeat.add(btSeatB3);
        this.listSeat.add(btSeatB4);
        this.listSeat.add(btSeatB5);
        this.listSeat.add(btSeatB6);
        this.listSeat.add(btSeatB7);
        this.listSeat.add(btSeatB8);
        this.listSeat.add(btSeatC1);
        this.listSeat.add(btSeatC2);
        this.listSeat.add(btSeatC3);
        this.listSeat.add(btSeatC4);
        this.listSeat.add(btSeatC5);
        this.listSeat.add(btSeatC6);
        this.listSeat.add(btSeatC7);
        this.listSeat.add(btSeatC8);
        this.listSeat.add(btSeatD1);
        this.listSeat.add(btSeatD2);
        this.listSeat.add(btSeatD3);
        this.listSeat.add(btSeatD4);
        this.listSeat.add(btSeatD5);
        this.listSeat.add(btSeatD6);
        this.listSeat.add(btSeatD7);
        this.listSeat.add(btSeatD8);
             
        
        //Chon ghe
        for (Button bt : listSeat) {
            bt.setOnAction(evt -> btSeat_click(bt));
        }
        //
        
        this.cbBus.setOnAction(evt -> loadSeat(listSeat));
        this.btConfirm.setOnAction(evt -> btConfirm_click());
        

    }   
    
    private void btSeat_click(Button bt) {
        
        String name = bt.textProperty().getValue();
        this.lbSeat.textProperty().setValue(name);
        
        try {
            int idS = BusStationServices.getBusStationByName(this.lbStart.getText()).getId();
            int idD = BusStationServices.getBusStationByName(this.lbDestination.getText()).getId();
            int idB = this.cbBus.getSelectionModel().getSelectedItem().getId();
            Date time = Date.valueOf(this.lbTime.getText());
            
            int price = TripServices.getTripWithoutId(idS, idD, time, idB).getPrice();
            this.lbPrice.setText(String.valueOf(price));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

  
    public void load(BusStation bsS, BusStation bsD, LocalDate time) {
        this.lbStart.setText(bsS.getBSName());
        this.lbDestination.setText(bsD.getBSName());
        this.lbTime.setText(time.toString());
        
        int idS = bsS.getId();
        int idD = bsD.getId();
        Date timeS = Date.valueOf(time);
       
        
        try {
            this.cbBus.getItems().addAll(TripServices.Bus_Filter(idS, idD, timeS));
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadSeat(List<Button> listbt) {
        
        try {
            int idS = BusStationServices.getBusStationByName(this.lbStart.getText()).getId();
            int idD = BusStationServices.getBusStationByName(this.lbDestination.getText()).getId();
            int idB = this.cbBus.getSelectionModel().getSelectedItem().getId();
            Date time = Date.valueOf(this.lbTime.getText());
            
            int idTrip = TripServices.getTripWithoutId(idS, idD, time, idB).getId();
            
            List<Seat> list_Seat = SeatServices.getSeatbyidTrip(idTrip);
            
            for (Seat seat : list_Seat) {
                for (int i = 0; i < 32; i++) {
                    String btName = listbt.get(i).getText();
                    if (seat.toString().equals(btName)) {
                        listbt.get(i).setVisible(false);
                    }
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void btConfirm_click() {
        
        if (txtName.getText() == null || txtName.getText() == "" 
                || txtPhoneNumber.getText() == null 
                || txtPhoneNumber.getText() == "") {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Canh Bao !");
            a.setContentText("Nhap thieu thong tin !");
            a.setHeaderText(null);
            a.showAndWait();
        }
        else {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Xac Nhan Dat Ve");
            a.setContentText("Ban chac chan muon dat ve ?");
            a.setHeaderText(null);
            a.showAndWait().ifPresent(res -> {
                    if (res == ButtonType.OK) {
                        
                        int price = Integer.valueOf(this.lbPrice.getText());
                        String name = this.txtName.getText().trim();
                        String fName = name.substring(0,name.lastIndexOf(" "));
                        String lName = name.substring(name.lastIndexOf(" ") + 1);
                        String sdt = this.txtPhoneNumber.getText().trim();
                        int idB = this.cbBus.getSelectionModel().getSelectedItem().getId();
                        Date time = Date.valueOf(this.lbTime.getText());
                        
                       
                        try {
                            
                            int idS = BusStationServices.getBusStationByName(this.lbStart.getText()).getId();
                            int idD = BusStationServices.getBusStationByName(this.lbDestination.getText()).getId();
                            if (CustomerServices.addCustomer(fName, lName, sdt)== true) {
                                
                                int idCus = CustomerServices.getCustomerWithoutId(fName, lName, sdt).getId();
                                int idTrip = TripServices.getTripWithoutId(idS, idD, time, idB).getId();
                                if (SeatServices.addSeat(this.lbSeat.getText(), idTrip) == true){
                                    
                                    int idSeat = SeatServices.getSeatWithoutId(this.lbSeat.getText(), idTrip).getId();
                                    
                                    if (TicketServices.addTicket(price, idCus, idSeat) == true) {
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setContentText("Dat ve thanh cong !");
                                        alert.setHeaderText(null);
                                        alert.showAndWait();
                                    }
                                }

                            }
                            
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
        }
    }
    
    
}
