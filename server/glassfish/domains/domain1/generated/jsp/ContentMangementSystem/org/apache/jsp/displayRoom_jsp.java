package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import scrumm.models.Room;
import scrumm.models.Customer;

public final class displayRoom_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      response.setHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Raum anzeigen</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Room room = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom();
            request.setAttribute("room", room);
            Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().setCurrentDevice(null);
        
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("                function confirmation(){\n");
      out.write("                    if(confirm(\"safe?\")){\n");
      out.write("                        document.getElementById(\"form\").submit();\n");
      out.write("                    } \n");
      out.write("                }\n");
      out.write("        </script>\n");
      out.write("        <a href=\"index.jsp\">Home</a>\n");
      out.write("        <a href=\"displayCustomer.jsp\">");
 out.print(" > " + Customer.currentCustomer.getBezeichnung()); 
      out.write("</a>\n");
      out.write("        <a href=\"displayBuilding.jsp\">");
 out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getBezeichnung()); 
      out.write("</a>\n");
      out.write("        <a href=\"displayFloor.jsp\">");
 out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getBezeichnung()); 
      out.write("</a><br>\n");
      out.write("        <h1>Ausgewählter Raum: </h1>\n");
      out.write("        Bezeichnung: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.getBezeichnung()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("<br>\n");
      out.write("        Raumnummer: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.getRaumnummer()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("<br>\n");
      out.write("        <form id=\"form\" name=\"DeleteRoomForm\" action=\"DeleteRoomServlet\">\n");
      out.write("            <input type=\"button\" value=\"Raum löschen\" name=\"delete\" onclick=\"confirmation()\"/><br>\n");
      out.write("        </form>\n");
      out.write("        <a href=\"createRoom.jsp\">Raum bearbeiten</a><br>\n");
      out.write("        <a href=\"createDevice.jsp\">Gerät hinzufügen</a><br>\n");
      out.write("        <a href=\"chooseDevice.jsp\">Gerät auswählen</a><br>\n");
      out.write("        <a href=\"displayCustomer.jsp\">Kunden anzeigen</a><br>\n");
      out.write("        <a href=\"displayBuilding.jsp\">Gebäude anzeigen</a><br>\n");
      out.write("        <a href=\"displayFloor.jsp\">Ebene anzeigen</a><br>\n");
      out.write("        <a href=\"index.jsp\">Zurück zum Hauptmenü</a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
