/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumm.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author ninacordes
 */
public class Room implements Serializable {
    
    private int id;
    private String bezeichnung;
    private String raumnummer;
    private ArrayList<Device> geraete;
    private Device currentDevice;
    
    public Room(String bezeichnung, String raumnummer) {
        this.bezeichnung = bezeichnung;
        this.raumnummer = raumnummer;
        
        geraete = new ArrayList<Device>();
    }

    public Room(String bezeichnung, String raumnummer, ArrayList<Device> geraete) {
        this.bezeichnung = bezeichnung;
        this.raumnummer = raumnummer;
        this.geraete = geraete;
    }
    
    public void addDevice(Device d){
        geraete.add(d);
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

    public String getRaumnummer() {
        return raumnummer;
    }

    public void setRaumnummer(String raumnummer) {
        this.raumnummer = raumnummer;
    }

    public ArrayList<Device> getGeraete() {
        return geraete;
    }

    public void setGeraete(ArrayList<Device> geraete) {
        this.geraete = geraete;
    }

    public Device getCurrentDevice() {
        return currentDevice;
    }

    public void setCurrentDevice(Device currentDevice) {
        this.currentDevice = currentDevice;
    }
   
    
}
