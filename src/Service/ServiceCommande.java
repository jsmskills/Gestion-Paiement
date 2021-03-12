/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.commande;

import Services.IServiceCommande;
import Utils.Maconnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class ServiceCommande implements IServiceCommande{
    Connection cnx;

    public ServiceCommande() {
        try {
            cnx=Maconnexion.getInstance().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void AddCommande(commande c) {
        PreparedStatement pst ;
        
        try {
            String sql="INSERT INTO commande(nomformation,prix)VALUES(?,?)";
            pst=cnx.prepareStatement(sql);
            pst.setString(1,c.getNomformation());
            pst.setFloat(2,c.getPrix());
            
            if(pst.executeUpdate()>0) 
                System.out.println("request send successfully!!!");
            else 
                System.out.println("failed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    ObservableList<commande>oblist2=FXCollections.observableArrayList();
    @Override
    public ObservableList<commande> AfficherCommande() throws SQLException {
        Statement stm=cnx.createStatement();
        String query="select* from `commande`";
        ResultSet rst=stm.executeQuery(query);
        commande c=new commande();
        while(rst.next()){
            c.setRef(rst.getInt("ref"));
            c.setNomformation(rst.getString("nomformation"));
            c.setPrix(rst.getInt("Prix"));
            
         oblist2.add(c);   
        }
        return oblist2;
        
        
    }

    @Override
    public void DeleteCommande(commande c) {
        int n2=0;
        PreparedStatement st;
        try {
            st=cnx.prepareStatement("DELETE FROM `commande` WHERE `ref`=?");
            st.setInt(1,c.getRef());
            n2=st.executeUpdate();
            if(n2>0)
                System.out.println("deleted");
            else 
                
                System.out.println("non-deleted");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void ModifyCommande(commande c) {
        String sql2="UPDATE commande SET nomformation=?,prix=?  WHERE ref=? ";
        
        try {
            PreparedStatement pstmt=cnx.prepareStatement(sql2);
            pstmt.setString(1, c.getNomformation());
            pstmt.setFloat(2,c.getPrix());
            pstmt.setInt(3, c.getRef());
           
            if(pstmt.executeUpdate()>0){
                System.out.println("Parfait commande a ete modifie avec succees ");
                
                   
            }
            else 
                System.out.println("Echec de modification");
            pstmt.close();
            
                
            
            
            
        } catch (SQLException ex) {
            System.out.println("Modify commande=="+ex.getMessage());
        }
        
        
    }
    
    @Override
    public commande getCommandeById(int ref) {
         commande c=new commande();
        
        try {
            String sql="SELECT * FROM commande WHERE ref="+ref;
            Statement stm=cnx.createStatement();
            ResultSet rst=stm.executeQuery(sql);
            while(rst.next()){
                c.setNomformation(rst.getString("nom formation"));
                c.setPrix(rst.getInt("prix"));
               
                
            
            
            }
        } catch (SQLException ex) {
            System.out.println("error"+ex.getMessage());
        }
        return c;
    }
        
    

           
                
        
    
    
}
