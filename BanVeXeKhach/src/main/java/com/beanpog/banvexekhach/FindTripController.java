package com.beanpog.banvexekhach;

import com.beanpog.banvexekhach.pojo.BusStation;
import com.beanpog.banvexekhach.services.BusStationServices;
import com.beanpog.banvexekhach.OrderController;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FindTripController implements Initializable {
    
    @FXML
    private ComboBox<BusStation> cbStart;
    @FXML
    private ComboBox<BusStation> cbDestination;
    @FXML
    private DatePicker dpTime;
    @FXML
    private Button btSearch;
    
    
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        this.cbDestination.setOnAction(evt -> cb_check());
        this.cbStart.setOnAction(evt -> cb_check());
        this.btSearch.setOnAction(evt -> {
            try {
                btsearch_click();        
                
            } catch (IOException ex) {
                Logger.getLogger(FindTripController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        try {
            this.cbStart.getItems().addAll(BusStationServices.getBusStation());
        } catch (SQLException ex) {
            Logger.getLogger(FindTripController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            this.cbDestination.getItems().addAll(BusStationServices.getBusStation());  
        } catch (SQLException ex) {
            Logger.getLogger(FindTripController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void cb_check() {
        if (this.cbDestination.getSelectionModel().getSelectedIndex() == this.cbStart.getSelectionModel().getSelectedIndex()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Canh Bao !");
            a.setContentText("Diem khoi hanh va diem den bi trung !");
            a.setHeaderText(null);
            a.showAndWait();
        }
    }
    
    private void btsearch_click() throws IOException {
        if (this.cbDestination.getSelectionModel().getSelectedIndex() == this.cbStart.getSelectionModel().getSelectedIndex() 
                || this.dpTime.getValue() == null 
                || this.cbDestination.getValue() == null 
                || this.cbStart.getValue() == null ){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Canh Bao !");
            a.setContentText("Nhap thieu thong tin !");
            a.setHeaderText(null);
            a.showAndWait();
        }
        else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("order.fxml"));

            Parent root = (Parent) loader.load();

            OrderController ctrl = loader.<OrderController>getController();
            ctrl.load(this.cbStart.getSelectionModel().getSelectedItem()
                    , this.cbDestination.getSelectionModel().getSelectedItem()
                    , this.dpTime.getValue());


            Scene newScene = new Scene(root);
            Stage newStg = new Stage();
            newStg.setScene(newScene);
            newStg.show();
        }
        
    }
    
}
