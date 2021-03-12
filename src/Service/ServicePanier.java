/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Panier;
import Entities.paiement;
import Services.IServicePanier;
import Utils.Maconnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class ServicePanier  implements  IServicePanier{
Connection cnx;

    public ServicePanier()  {
        try {
            cnx=Maconnexion.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicePaiement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    List<Panier>list = new ArrayList<Panier>();
    @Override
    public List<Panier> getAllPanier() {
    
        Panier panier = new Panier();
                 String query="select* from `panier`";

        Statement stm;
    try {
        stm = cnx.createStatement();
        ResultSet rst=stm.executeQuery(query);
        while(rst.next()){
            panier.setId(rst.getInt("id"));
            panier.setId_formation(rst.getInt("id_formation"));
            list.add(panier);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServicePanier.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return list;
    
    }
    
    
}
