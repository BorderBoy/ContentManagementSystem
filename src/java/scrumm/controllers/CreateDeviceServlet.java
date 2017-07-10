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
        
        
        request.setCharacterEncoding("UTF-8");
        
        int type = -1;
        
        System.out.println(request.getParameter("klasse"));
        
        if(request.getParameter("klasse") != null){    
            type = Integer.parseInt(request.getParameter("klasse"));
        } else {
            type = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getCurrentDevice().getKlasse();            
        }
       
        if(Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getCurrentDevice() == null){
            Device device = new Device(request.getParameter("bezeichnung"), type, Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getBemerkung(), Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getBezeichnung(), Customer.currentCustomer.getCurrentBuilding().getBezeichnung(), Customer.currentCustomer.increaseMaxID(type), Customer.currentCustomer.getBezeichnung(), Customer.currentCustomer.getId());
            
            device.store();
            
            Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().addDevice(device);
            Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().setCurrentDevice(device);
            Customer.currentCustomer.update();
        } else {
            Device device = new Device(Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getCurrentDevice().getId(), request.getParameter("bezeichnung"), type, Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getBezeichnung(), Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getBezeichnung(),Customer.currentCustomer.getBezeichnung(), Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getCurrentDevice().getKey(), Customer.currentCustomer.getBezeichnung(), Customer.currentCustomer.getId());
            
            device.update();
            
            Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getGeraete().set(Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getGeraete().indexOf(Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getCurrentDevice()), device);
            Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().setCurrentDevice(device);
            Customer.currentCustomer.update();
        }
        
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
