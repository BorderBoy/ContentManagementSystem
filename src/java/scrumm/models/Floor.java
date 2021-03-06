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
    
    private int id;
    private String bezeichnung;
    private String bemerkung;
    private ArrayList<Room> raeume;
    private Room currentRoom;
    

    public Floor(String bezeichnung, String bemerkung, ArrayList<Room> raeume) {
        this.bezeichnung = bezeichnung;
        this.bemerkung = bemerkung;
        this.raeume = raeume;
    }

    public Floor(String bezeichnung, String bemerkung) {
        this.bezeichnung = bezeichnung;
        this.bemerkung = bemerkung;
        
        raeume = new ArrayList<Room>();
    }
    
    public void addRoom(Room r){
        raeume.add(r);
    }
    
    public void removeCurrentRoom(){
         raeume.remove(currentRoom);
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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    
    
    
}
