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
import scrumm.models.Customer;
import scrumm.models.Room;

/**
 *
 * @author Uli
 */
@WebServlet(name = "CreateRoomServlet", urlPatterns = {"/CreateRoomServlet"})
public class CreateRoomServlet extends HttpServlet {

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
        
        if(Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom() == null){
            Room room = new Room(request.getParameter("bezeichnung"),request.getParameter("raumnummer"));
            Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().addRoom(room);
            Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().setCurrentRoom(room);
            Customer.currentCustomer.update();
        } else {
            Room room = new Room(request.getParameter("bezeichnung"), request.getParameter("raumnummer"), Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getGeraete());
            Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getRaeume().set(Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getRaeume().indexOf(Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom()), room);
            Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().setCurrentRoom(room);
            Customer.currentCustomer.update();
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/displayRoom.jsp");
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
