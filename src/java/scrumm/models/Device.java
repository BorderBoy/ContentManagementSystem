/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumm.models;

import java.io.Serializable;

/**
 *
 * @author Jonas
 */
public class Device implements Serializable {
    
     private int id;
     private String bezeichnung;
     private int klasse;

    public Device(int id, String bezeichnung, int klasse) {
        this.id = id;
        this.bezeichnung = bezeichnung;
        this.klasse = klasse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }
    
    
}
