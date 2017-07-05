/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumm.models;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jonas
 */
public class Customer implements Serializable {
    
    private String vorname;
    private String nachname;
    private String bezeichnung;
    private String ort;
    private String adresse;
    private ArrayList<Building> gebaeude;
    private int plz;
    private String telefonnummer;       
    private String bemerkung;
    private int id;
    private Building currentBuilding;
    
    public static Customer currentCustomer;
    

    public Customer(String vorname, String nachname, String bezeichnung, String ort, String adresse, ArrayList<Building> gebaeude, int plz, String telefonnummer, String bemerkung) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.bezeichnung = bezeichnung;
        this.ort = ort;
        this.adresse = adresse;
        this.gebaeude = gebaeude;
        this.plz = plz;
        this.telefonnummer = telefonnummer;
        this.bemerkung = bemerkung;
        id = -1;
        
    }

    public Customer(String vorname, String nachname, String bezeichnung, String ort, String adresse, int plz, String telefonnummer, String bemerkung) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.bezeichnung = bezeichnung;
        this.ort = ort;
        this.adresse = adresse;
        this.plz = plz;
        this.telefonnummer = telefonnummer;
        this.bemerkung = bemerkung;
        id = -1;
        
        gebaeude = new ArrayList<Building>();
        
    }

    public Customer(String vorname, String nachname, String bezeichnung, String ort, String adresse, ArrayList<Building> gebaeude, int plz, String telefonnummer, String bemerkung, int id) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.bezeichnung = bezeichnung;
        this.ort = ort;
        this.adresse = adresse;
        this.gebaeude = gebaeude;
        this.plz = plz;
        this.telefonnummer = telefonnummer;
        this.bemerkung = bemerkung;
        this.id = id;
    }
    
    
    
  
    
    
    public void store(){
        
        Connection cn;
        PreparedStatement insertCustomer;
        //Statement st;
        //ResultSet rs;
        
        String currentDir = System.getProperty("user.dir");
                
        
        
        try {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");
            
            cn.setAutoCommit(false);
            
            insertCustomer = cn.prepareStatement("INSERT INTO kunde (ort,adresse,bezeichnung,plz,vorname,nachname,telefonnummer,bemerkung, gebaeude) VALUES ('"+ort+"','"+adresse+"','"+bezeichnung+"','"+plz+"','"+vorname+"','"+nachname+"','"+telefonnummer+"','"+bemerkung+"', ?)", Statement.RETURN_GENERATED_KEYS);
            
            
            insertCustomer.setBytes(1, convertToBytes(gebaeude));
            int newRow = insertCustomer.executeUpdate();
            
            if (newRow == 0) {
                throw new SQLException("Creating customer failed, no rows affected.");
            }

            try (ResultSet generatedKeys = insertCustomer.getGeneratedKeys()) {
                if(generatedKeys.next()) {
                    id = (int) generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating customer failed");
                }
            }
             
            cn.commit();
           
            cn.setAutoCommit(true);
            
            insertCustomer.close();
            cn.close();
            

        } catch (Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        System.out.println("Created Customer successfully");
        
        
        /*try {
            ArrayList<String> result = new ArrayList<String>();
            
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");
            st = cn.createStatement();  
            
            rs = st.executeQuery("SELECT gebaeude FROM kunde");
            
            System.out.println(convertToArrayList(rs.getBytes("gebaeude")).get(0).getAdresse());
            
        } catch (Exception e) {
        }*/
        
    }
    
    public void update(){
        Connection cn;
        
        PreparedStatement updateCustomer;
        
         try {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");
            
            cn.setAutoCommit(false);
            
            updateCustomer = cn.prepareStatement("UPDATE kunde SET gebaeude = ? WHERE kundenID = " + id);
            
            
            updateCustomer.setBytes(1, convertToBytes(gebaeude));
            int newRow = updateCustomer.executeUpdate();
            
            if (newRow == 0) {
                throw new SQLException("Updating customer failed, no rows affected.");
            }
             
            cn.commit();
           
            cn.setAutoCommit(true);
            
            updateCustomer.close();
            cn.close();

        } catch (Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        System.out.println("Updated Customer successfully");
        
    }
    
    public void delete(){
        Connection cn;
        
        Statement deleteCustomer;
        
         try {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");

            deleteCustomer = cn.createStatement();
            deleteCustomer.execute("DELETE FROM kunde WHERE kundenID="+id);
            
            
            deleteCustomer.close();
            cn.close();
            
            System.out.println("Deleted Customer successfully");

        } catch (Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        
        
        Customer.currentCustomer = null;
    }
    
     public void addBuilding(Building b){
       gebaeude.add(b);
    }
     
     public void removeCurrentBuilding(){
         gebaeude.remove(currentBuilding);
     }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public ArrayList<Building> getGebaeude() {
        return gebaeude;
    }

    public void setGebaeude(ArrayList<Building> gebaeude) {
        this.gebaeude = gebaeude;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static void setCurrentCustomer(Customer c){
        currentCustomer = c;
    }

    public Building getCurrentBuilding() {
        return currentBuilding;
    }

    public void setCurrentBuilding(Building currentBuilding) {
        this.currentBuilding = currentBuilding;
    }
    
    
    
    
    
    
    public byte[] convertToBytes(ArrayList<Building> list) throws IOException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(list);
        return bos.toByteArray();
    }
    
    public ArrayList<Building> convertToArrayList(byte[] bytes) throws IOException, ClassNotFoundException{
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        
        return (ArrayList<Building>) ois.readObject();
    }
    
    
}
