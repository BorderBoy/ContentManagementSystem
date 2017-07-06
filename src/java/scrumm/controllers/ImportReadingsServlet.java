/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumm.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ninacordes
 */
@WebServlet(name = "ImportReadingsServlet", urlPatterns = {"/ImportReadingsServlet"})
public class ImportReadingsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*BufferedReader br = new BufferedReader(new FileReader("your file"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split("','");    //your seperator

            //Convert String to right type. Integer, double, date etc.
            stat.executeUpdate("INSERT INTO yourTable VALUES('" + value[0] + "','" + value[1]
        
        ...
                 //Use a PeparedStatemant, it´s easier and safer 
        }
        br.close();*/
        try {
            Connection cn;
            PreparedStatement st;
            ResultSet rs;

            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");
            cn.setAutoCommit(false);

            BufferedReader br = new BufferedReader(new FileReader("../../../../../table.csv"));
            String line;
            String[] columNames = new String[41];
            
            if((line = br.readLine()) !=null){
                columNames = line.split(";");
            }
            
            
            try{
                br.readLine();
                br.readLine();
                br.readLine();
                br.readLine();
                br.readLine();            
            } catch(NullPointerException e) {
                
            }
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";", -1);    //your seperator
                
                System.out.println(line);
                System.out.println("a" + values[2]);
                
                
                System.out.println("Länge: " + values.length);
                //System.out.println("INSERT INTO messergebnis ("+columNames[6]+"','"+columNames[7]+"','"+columNames[8]+"','"+columNames[9]+"','"+columNames[10]+"','"+columNames[11]+"','"+columNames[12]+"','"+columNames[13]+"','"+columNames[14]+"','"+columNames[15]+"','"+columNames[16]+"','"+columNames[17]+"','"+columNames[18]+"','"+columNames[19]+"','"+columNames[20]+"','"+columNames[21]+"','"+columNames[22]+"','"+columNames[23]+"','"+columNames[24]+"','"+columNames[25]+"','"+columNames[26]+"','"+columNames[27]+"','"+columNames[28]+"','"+columNames[29]+"','"+columNames[30]+"','"+columNames[31]+"','"+columNames[32]+"','"+columNames[33]+"','"+columNames[34]+"','"+columNames[35]+"','"+columNames[36]+"','"+columNames[37]+"','"+columNames[38]+"','"+columNames[39]+"','"+columNames[40]+") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
                st = cn.prepareStatement("INSERT INTO messergebnis ('"+columNames[6]+"','"+columNames[7]+"','"+columNames[8]+"','"+columNames[9]+"','"+columNames[10]+"','"+columNames[11]+"','"+columNames[12]+"','"+columNames[13]+"','"+columNames[14]+"','"+columNames[15]+"','"+columNames[16]+"','"+columNames[17]+"','"+columNames[18]+"','"+columNames[19]+"','"+columNames[20]+"','"+columNames[21]+"','"+columNames[22]+"','"+columNames[23]+"','"+columNames[24]+"','"+columNames[25]+"','"+columNames[26]+"','"+columNames[27]+"','"+columNames[28]+"','"+columNames[29]+"','"+columNames[30]+"','"+columNames[31]+"','"+columNames[32]+"','"+columNames[33]+"','"+columNames[34]+"','"+columNames[35]+"','"+columNames[36]+"','"+columNames[37]+"','"+columNames[38]+"','"+columNames[39]+"','"+columNames[40]+"') VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
                
                for(int i = 6; i < values.length; i++){
                    st.setString(i-5, values[i]);
                 }
                
                st.executeUpdate();
                cn.commit();      
                st.close();
                 //Use a PeparedStatemant, it´s easier and safer 
            }
            
            
            cn.commit();
            cn.setAutoCommit(true);
            
            
            br.close();

            
            cn.close();

        } catch (Exception e) {               
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");  

        dispatcher.forward(request, response);  

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
