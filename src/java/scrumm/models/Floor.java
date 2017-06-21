/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumm.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ninacordes
 */
public class Floor implements Serializable{
    
    int id;
    String bezeichnung;
    String bemerkung;
    ArrayList<Room> raeume;

    public Floor(String bezeichnung, String bemerkung, ArrayList<Room> raeume) {
        this.bezeichnung = bezeichnung;
        this.bemerkung = bemerkung;
        this.raeume = raeume;
    }

    public Floor(String bezeichnung, String bemerkung) {
        this.bezeichnung = bezeichnung;
        this.bemerkung = bemerkung;
    }
    
    public void addRoom(Room r){
        raeume.add(r);
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

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public ArrayList<Room> getRaeume() {
        return raeume;
    }

    public void setRaeume(ArrayList<Room> raeume) {
        this.raeume = raeume;
    }

    
    
}
