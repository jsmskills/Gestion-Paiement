/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionpaiement;

import Entities.Panier;

import Service.ServicePanier;
import animatefx.animation.FadeOut;
import animatefx.animation.ZoomIn;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLPanierController implements Initializable {

  
    private Pane pane3;
    @FXML
    private TableView<?> t;
    @FXML
    private TableColumn<?, ?> txt1;
    @FXML
    private TableColumn<?, ?> txt2;
    @FXML
    private TableColumn<?, ?> datep;
    @FXML
    private AnchorPane pane1;
    @FXML
    private Label tt;
    @FXML
    private Pane p1;
    @FXML
    private Pane paneButton;
    @FXML
    private Label titre;
    private Pane paneFormation;
    @FXML
    private Button btnAddPayer;
    @FXML
    private Label id_formation;
    @FXML
    private ListView<Panier> listV;

    /**
     * Initializes the controller class.
     */
         ObservableList<Panier>oblist=FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
        ServicePanier servicePanier = new ServicePanier();
        
        /*
 * Each row in a ListView should be 24px tall.  Also, we have to add an extra
 * two px to account for the borders of the ListView.
 */

        List<Panier>res = new ArrayList<Panier>();
   
        res = servicePanier.getAllPanier();
        for(Panier p : res) {
            titre.setText("id panier="+String.valueOf(p.getId()));
            id_formation.setText("id formation="+String.valueOf(p.getId_Formation()));
                  listV.setItems(oblist);      
  
        }
           
        final int ROW_HEIGHT = 24;

// This sets the initial height of the ListView:
listV.setPrefHeight(oblist.size() * ROW_HEIGHT + 2);
     
    }
    @FXML
    private void payer(ActionEvent event) {
        
        
        }
        
        
    
    
}
