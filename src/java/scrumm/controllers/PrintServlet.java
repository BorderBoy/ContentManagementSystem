/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFGraphics;
import com.qoppa.pdfWriter.PDFPage;
import com.sun.xml.rpc.processor.generator.CustomClassGenerator;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import scrumm.models.Customer;


/**
 *
 * @author Jonas
 */
@WebServlet(name = "PrintServlet", urlPatterns = {"/PrintServlet"})
public class PrintServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        Customer currentCustomer = Customer.currentCustomer;
        PDFDocument pdfDoc = new PDFDocument();
        
        try {
                Connection cn;
                Statement st;
                ResultSet rs;

                Class.forName("org.sqlite.JDBC");
                cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");
                st = cn.createStatement();

                rs = st.executeQuery("SELECT messergebnis.*, geraet.bezeichnung as 'gerätebezeichnung' FROM messergebnis INNER JOIN geraet ON messergebnis.geraeteID=geraet.geraeteID WHERE messergebnis.kundenID =" + currentCustomer.getId() + ";");

                while (rs.next()) {
                    PDFPage newPage = pdfDoc.createPage(new PageFormat());
                    Graphics2D g2d = newPage.createGraphics();
                    g2d.setFont(PDFGraphics.HELVETICA.deriveFont(50f));
                    g2d.drawString(rs.getString("gerätebezeichnung"), 100, 100);
                    g2d.setFont(PDFGraphics.HELVETICA.deriveFont(9f));
                    
                    for(int i = 1; i <= rs.getMetaData().getColumnCount()-1; i++){
                        
                            g2d.drawString(rs.getMetaData().getColumnName(i)+": "+rs.getString(i), 100,120+i*12);
                        
                        
                    }
                    
                   pdfDoc.addPage(newPage);    
                }

                rs.close();
                st.close();
                cn.close();

            } catch (Exception e) {
            }
        
        
        try {
            pdfDoc.saveDocument("../../../../../output.pdf");
        } catch(IOException e){
            System.out.println("Document is used by other application!");
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/displayCustomer.jsp");  
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
