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
import java.awt.print.Paper;
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

                rs = st.executeQuery("SELECT messergebnis.*, geraet.bezeichnung as 'gerätebezeichnung', geraet.kunde, geraet.gebaeude, geraet.etage, geraet.raum FROM messergebnis INNER JOIN geraet ON messergebnis.geraeteID=geraet.geraeteID WHERE messergebnis.kundenID =" + currentCustomer.getId() + ";");

                
                
                while (rs.next()) {
                    double cm = 72 / 2.54;
                    
                    PageFormat pf = new PageFormat();
                    Paper p = new Paper();
                    p.setSize(21*cm, 29.5*cm);
                    double margin = 2*cm;
                    p.setImageableArea(margin, margin, p.getWidth() - margin * 2, p.getHeight()- margin * 2);
                    pf.setPaper(p);
                    
                    PDFPage newPage = pdfDoc.createPage(pf);
                    Graphics2D g2d = newPage.createGraphics();
                    g2d.setFont(PDFGraphics.HELVETICA.deriveFont(9f));
                    g2d.drawString("Gerätebezeichnung:", 75, 70);
                    g2d.setFont(PDFGraphics.HELVETICA.deriveFont(25f));
                    g2d.drawString(rs.getString("gerätebezeichnung"), 75, 90);
                    g2d.setFont(PDFGraphics.HELVETICA.deriveFont(9f));
                    
                    int counter = 1;
                    
                    for(int i = 1; i <= rs.getMetaData().getColumnCount()-5; i++){
                        if((rs.getString(i) != null)&&(rs.getString(i).equals("") == false)){
                            g2d.drawString(rs.getMetaData().getColumnName(i)+": "+rs.getString(i), 75,100+counter*12);
                            counter++;
                        }
                    }
                    
                    System.out.println("page");
                    
                    g2d.drawString("Kunde: "+ rs.getString("kunde"), 400, 70);
                    g2d.drawString("Gebäude: "+ rs.getString("gebaeude"), 400, 70 + 12);
                    g2d.drawString("Etage: "+ rs.getString("etage"), 400, 70 + 12*2);
                    g2d.drawString("Raum: "+ rs.getString("raum"), 400, 70 + 12*3);
                    
                    
                    
                    pdfDoc.addPage(newPage);    
                }

                rs.close();
                st.close();
                cn.close();

            } catch (Exception e) {
            }
        
        
        try {
            pdfDoc.saveDocument("../../../../../output.pdf");
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/displayCustomer.jsp");  
            dispatcher.forward(request, response);
        } catch(IOException e){
            System.out.println("Document is used by other application!");
            response.sendError(HttpServletResponse.SC_CONFLICT, "Document is used by other application!");
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
