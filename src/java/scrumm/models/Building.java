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
public class Building implements Serializable {
    
    ArrayList<Floor> ebenen;
    int id;
    String bezeichnung;
    String adresse;
    int plz;
    String ort;
    String bemerkung;

    public Building(String bezeichnung, String adresse, int plz, String ort, String bemerkung) {
        this.bezeichnung = bezeichnung;
        this.adresse = adresse;
        this.plz = plz;
        this.ort = ort;
        this.bemerkung = bemerkung;
        
        ebenen = new ArrayList<Floor>();
    }

    public Building(ArrayList<Floor> ebenen, String bezeichnung, String adresse, int plz, String ort, String bemerkung) {
        this.ebenen = ebenen;
        this.bezeichnung = bezeichnung;
        this.adresse = adresse;
        this.plz = plz;
        this.ort = ort;
        this.bemerkung = bemerkung;
    }
    
    
    public void addFloor(Floor f){
        ebenen.add(f);
    }
    
    

    public ArrayList<Floor> getEbenen() {
        return ebenen;
    }

    public void setEbenen(ArrayList<Floor> ebenen) {
        this.ebenen = ebenen;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }
    
    
    
}
