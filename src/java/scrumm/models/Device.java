/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumm.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class Device implements Serializable {
    
     private int id;
     private String bezeichnung;
     private int klasse;
     private String etage;
     private String raum;
     private String gebaeude;
     private int key;
     private String kunde;
     private int kundenID;

    public Device(int id, String bezeichnung, int klasse) {
        this.id = id;
        this.bezeichnung = bezeichnung;
        this.klasse = klasse;
    }

    public Device(String bezeichnung, int klasse) {
        this.bezeichnung = bezeichnung;
        this.klasse = klasse;
    }

    public Device(String bezeichnung, int klasse, String etage, String raum, String gebaeude, int id, String kunde, int kundenID) {
        this.bezeichnung = bezeichnung;
        this.klasse = klasse;
        this.etage = etage;
        this.raum = raum;
        this.gebaeude = gebaeude;
        this.id = id;
        this.kunde = kunde;
        this.kundenID = kundenID;
    }

    public Device(int id, String bezeichnung, int klasse, String etage, String raum, String gebaeude, int key, String kunde, int kundenID) {
        this.id = id;
        this.bezeichnung = bezeichnung;
        this.klasse = klasse;
        this.etage = etage;
        this.raum = raum;
        this.gebaeude = gebaeude;
        this.key = key;
        this.kunde = kunde;
        this.kundenID = kundenID;
    }
    
    
    
    
    public void store(){
        Connection cn;
            PreparedStatement insertCustomer;

            try {
                Class.forName("org.sqlite.JDBC");
                cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");

                cn.setAutoCommit(false);

                insertCustomer = cn.prepareStatement("INSERT INTO geraet (geraeteID, gebaeude, etage, raum, bezeichnung, kundenID, kunde) VALUES (?,?,?,?,?,?,?)");

                insertCustomer.setInt(1, id);
                insertCustomer.setString(2, gebaeude);
                insertCustomer.setString(3, etage);
                insertCustomer.setString(4, raum);
                insertCustomer.setString(5, bezeichnung);
                insertCustomer.setInt(6, kundenID);
                insertCustomer.setString(7, kunde);

                int newRow = insertCustomer.executeUpdate();
                
                if (newRow == 0) {
                    throw new SQLException("Creating customer failed, no rows affected.");
                }

                try (ResultSet generatedKeys = insertCustomer.getGeneratedKeys()) {
                    if(generatedKeys.next()) {
                        key = (int) generatedKeys.getLong(1);
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
            
            System.out.println("Created Device successfully");
    }
    
    public void update(){
        Connection cn;
            PreparedStatement insertCustomer;

            try {
                Class.forName("org.sqlite.JDBC");
                cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");

                cn.setAutoCommit(false);

                insertCustomer = cn.prepareStatement("UPDATE geraet SET bezeichnung = ? WHERE key = " + key);

                insertCustomer.setString(1, bezeichnung);
                
                insertCustomer.executeUpdate();

                cn.commit();

                cn.setAutoCommit(true);

                insertCustomer.close();
                cn.close();


            } catch (Exception e ) {
              System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
            System.out.println("Created Device successfully");
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

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public String getRaum() {
        return raum;
    }

    public void setRaum(String raum) {
        this.raum = raum;
    }

    public String getGebaeude() {
        return gebaeude;
    }

    public void setGebaeude(String gebaeude) {
        this.gebaeude = gebaeude;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getKunde() {
        return kunde;
    }

    public void setKunde(String kunde) {
        this.kunde = kunde;
    }

    public int getKundenID() {
        return kundenID;
    }

    public void setKundenID(int kundenID) {
        this.kundenID = kundenID;
    }
    
    
}
