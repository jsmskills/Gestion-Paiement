/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author ASUS
 */
public class Panier {
    
    private int id;
    private int id_formation;

    
    
    public Panier() {
        
    }
    public Panier(int id, int id_formation) {
        this.id = id;
        this.id_formation = id_formation;
    }

    public Panier(int id_formation) {
        this.id_formation = id_formation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", id_formation=" + id_formation + '}';
    }
    
    
    
}
