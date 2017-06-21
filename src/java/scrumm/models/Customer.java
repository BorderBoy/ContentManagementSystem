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
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jonas
 */
public class Customer implements Serializable {
    
    String vorname;
    String nachname;
    String bezeichnung;
    String ort;
    String adresse;
    ArrayList<Building> gebaeude;
    int plz;
    String telefonnummer;       
    String bemerkung;

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
    }
    
   public void addBuilding(Building b){
       gebaeude.add(b);
   }
    
    
    public void store(){
       
        System.out.println("yoyeah");
       
        
        //
        ArrayList<String> g = new ArrayList<String>();
        g.add("ajfegdgdgak");
        g.add("fjdgdsgdfgdaff");
        
        
        
        
        //
        Connection cn;
        Statement st;
       
        ResultSet rs;
        
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" +currentDir);
                
        PreparedStatement insertCustomer;
        
        try {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");
            st = cn.createStatement();  
            
            //cn.setAutoCommit(false);
            
            insertCustomer = cn.prepareStatement("INSERT INTO kunde (ort,adresse,bezeichnung,plz,vorname,nachname,telefonnummer,bemerkung) VALUES ('"+ort+"','"+adresse+"','"+bezeichnung+"','"+plz+"','"+vorname+"','"+nachname+"','"+telefonnummer+"','"+bemerkung+"')");
            st.executeUpdate("INSERT INTO kunde (ort,adresse,bezeichnung,plz,vorname,nachname,telefonnummer,bemerkung) VALUES ('"+ort+"','"+adresse+"','"+bezeichnung+"','"+plz+"','"+vorname+"','"+nachname+"','"+telefonnummer+"','"+bemerkung+"')");
            
            //Array gebaeudeArray = cn.createArrayOf("VARCHAR", gebaeude);
            //insertCustomer.setBytes(1, convertToBytes(g));
            //insertCustomer.executeUpdate();
            //cn.commit();
            //st.executeUpdate("INSERT INTO kunde (name, land, stadt, plz, strasse, gebaude) VALUES ('"+name+"', '"+land+"','"+stadt+"','"+plz+"', '"+strasse+"',@gebaude)");
            
            //cn.setAutoCommit(true);
            
            st.close();
            cn.close();

        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Opened database successfully");
        
        
       /* try {
            ArrayList<String> result = new ArrayList<String>();
            
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");
            st = cn.createStatement();  
            
            rs = st.executeQuery("SELECT gebaeude FROM kunde");
            
            while (rs.next()) {
                result = convertToStringList(rs.getBytes("gebaeude"));
            }
            
            System.out.println(result.get(0));
            System.out.println(result.get(1));
            
        } catch (Exception e) {
        }*/
        
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
    
    
    
    
    
    public byte[] convertToBytes(ArrayList<String> list) throws IOException{
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        DataOutputStream dout = new DataOutputStream(bout);
        for(String s : list){
            dout.writeUTF(s);
        }
        dout.close();
        return bout.toByteArray();
    }
    
    public ArrayList<String> convertToStringList(byte[] bytes) throws IOException{
        ArrayList<String> result = new ArrayList<String>();
        
        ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
        DataInputStream din = new DataInputStream(bin);
        while(din.available() > 0){
            result.add(din.readUTF());
        }
        
        return result;
    }
    
}
