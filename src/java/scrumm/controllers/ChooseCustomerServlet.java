/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumm.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import scrumm.models.Building;
import scrumm.models.Customer;

/**
 *
 * @author Jonas
 */
@WebServlet(name = "ChooseCustomerServlet", urlPatterns = {"/ChooseCustomerServlet"})
public class ChooseCustomerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String customerListID = "customerListBean";
    private ArrayList<String[]> customerList;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        customerList = new ArrayList<String[]>();
        
        try {
            Connection cn;
            Statement st;
            ResultSet rs;
            
            
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");
            st = cn.createStatement();  
            
            rs = st.executeQuery("SELECT * FROM kunde ORDER BY bezeichnung desc");
            
            
            while(rs.next()){
                //customerList.add(new Customer(rs.getString("vorname"), rs.getString("nachname"), rs.getString("bezeichnung"), rs.getString("ort"), rs.getString("adresse"), convertToArrayList(rs.getBytes("gebaeude")), rs.getInt("plz"), rs.getString("telefonnummer"), rs.getString("bemerkung"), rs.getInt("kundenID")));
                String[] array;
                array = new String[2];
                array[0] = rs.getInt("kundenID")+"";
                array[1] = rs.getString("bezeichnung");
                customerList.add(array);
            }
            
            rs.close();
            st.close();
            cn.close();
            
            
            
        } catch (Exception e) {
        }
        
        
       
        
        request.setAttribute(customerListID, customerList);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/chooseCustomer.jsp");  

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
    
    public ArrayList<Building> convertToArrayList(byte[] bytes) throws IOException, ClassNotFoundException{
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        
        return (ArrayList<Building>) ois.readObject();
    } //temporary: centralize!

}
