/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author ninacordes
 */
@WebServlet(name = "CreateBuildingServlet", urlPatterns = {"/CreateBuildingServlet"})
public class CreateBulidingServlet extends HttpServlet {

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
        
         try{
             
            int num = Integer.parseInt(request.getParameter("plz"));
                
            if(Customer.currentCustomer.getCurrentBuilding() == null){
                Building building = new Building(request.getParameter("bezeichnung"),request.getParameter("adresse"),Integer.parseInt(request.getParameter("plz")),request.getParameter("ort"),request.getParameter("bemerkung"));
                Customer.currentCustomer.addBuilding(building);
                Customer.currentCustomer.setCurrentBuilding(building);
                Customer.currentCustomer.update();
            } else {
                Building building = new Building(Customer.currentCustomer.getCurrentBuilding().getEbenen(), request.getParameter("bezeichnung"),request.getParameter("adresse"),Integer.parseInt(request.getParameter("plz")),request.getParameter("ort"),request.getParameter("bemerkung"));
                Customer.currentCustomer.getGebaeude().set(Customer.currentCustomer.getGebaeude().indexOf(Customer.currentCustomer.getCurrentBuilding()), building);
                Customer.currentCustomer.setCurrentBuilding(building);
                Customer.currentCustomer.update();
            }
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/displayBuilding.jsp");  
            dispatcher.forward(request, response);
            
            
         }catch(NumberFormatException e){
             
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/createBuilding.html");  
            dispatcher.forward(request, response);
         }
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
