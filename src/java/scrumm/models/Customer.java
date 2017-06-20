/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumm.models;

import java.io.File;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Jonas
 */
public class Customer implements Serializable {
    
    String name;
    String stadt;
    String strasse;
    String land;
    int plz;

        

    public Customer(String name, String land, String stadt, int plz, String strasse) {
        this.name = name;
        this.stadt = stadt;
        this.strasse = strasse;
        this.land = land;
        this.plz = plz;
        
    }
    
    
    public void store(){
       
        Connection cn;
        Statement st;
        try {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:..//..//..//..//..//cms.db");
            st = cn.createStatement();        


            
            st.executeUpdate("INSERT INTO kunde (name, land, stadt, plz, strasse) VALUES ('"+name+"', '"+land+"','"+stadt+"','"+plz+"', '"+strasse+"')");

            st.close();
            cn.close();

        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Opened database successfully");
        
    }
    
    public String getName() {
        return name;
    }

    public String getStadt() {
        return stadt;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getLand() {
        return land;
    }

    public int getPlz() {
        return plz;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }
    
}
