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
public class commande {
    private int ref;
    private String nomformation;
    private int prix;

    public commande() {
    }

    public commande(int ref, String nomformation, int prix) {
        this.ref = ref;
        this.nomformation = nomformation;
        this.prix = prix;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getNomformation() {
        return nomformation;
    }

    public void setNomformation(String nomformation) {
        this.nomformation = nomformation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "commande{" + "ref=" + ref + ", nomformation=" + nomformation + ", prix=" + prix + "}\n";
    }
    
    
}
