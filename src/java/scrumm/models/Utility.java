/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumm.models;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Jonas
 */
public final class Utility {
    
    private Utility(){
    
    }
    
    public static ArrayList<Building> convertToArrayList(byte[] bytes) throws IOException, ClassNotFoundException{
        if(bytes != null){
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);

            return (ArrayList<Building>) ois.readObject();
        } else {
            
            return null;
        }
    }
    
}
