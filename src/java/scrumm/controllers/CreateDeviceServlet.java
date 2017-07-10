/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import scrumm.models.Customer;
import scrumm.models.Device;
import scrumm.models.Room;

/**
 *
 * @author Uli
 */
@WebServlet(name = "CreateDeviceServlet", urlPatterns = {"/CreateDeviceServlet"})
public class CreateDeviceServlet extends HttpServlet {

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
        
        int type = Integer.parseInt(request.getParameter("klasse"));
       
        
        Device device = new Device(Customer.currentCustomer.increaseMaxID(type),request.getParameter("bezeichnung"),type);
        
        
        
        Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().addDevice(device);
        Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().setCurrentDevice(device);
        Customer.currentCustomer.update();
        
        
        Connection cn;
        PreparedStatement insertCustomer;
        
        try {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");
            
            cn.setAutoCommit(false);
            
            insertCustomer = cn.prepareStatement("INSERT INTO geraet (geraeteID, gebaeude, etage, raum, bezeichnung, kundenID, kunde) VALUES (?,?,?,?,?,?,?)");
            
            insertCustomer.setInt(1, device.getId());
            insertCustomer.setString(2, Customer.currentCustomer.getCurrentBuilding().getBezeichnung());
            insertCustomer.setString(3, Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getBezeichnung());
            insertCustomer.setString(4, Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getBezeichnung());
            insertCustomer.setString(5, device.getBezeichnung());
            insertCustomer.setInt(6, Customer.currentCustomer.getId());
            insertCustomer.setString(7, Customer.currentCustomer.getBezeichnung());
            
            insertCustomer.executeUpdate();
             
            cn.commit();
           
            cn.setAutoCommit(true);
            
            insertCustomer.close();
            cn.close();
            

        } catch (Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        System.out.println("Created Device successfully");
        
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/displayDevice.jsp");
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
