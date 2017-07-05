package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import scrumm.models.Floor;
import scrumm.models.Building;
import scrumm.models.Customer;

public final class displayFloor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Ebene anzeigen</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       ");

            Floor floor = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor();
            request.setAttribute("floor", floor);
        
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("        function confirmation(){\n");
      out.write("                    if(confirm(\"safe?\")){\n");
      out.write("                        document.getElementById(\"form\").submit();\n");
      out.write("                    } \n");
      out.write("                }\n");
      out.write("        </script>\n");
      out.write("        <a href=\"displayCustomer.jsp\">");
 out.print(Customer.currentCustomer.getBezeichnung()); 
      out.write("</a>\n");
      out.write("        <a href=\"displayBuidling.jsp\">");
 out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getBezeichnung()); 
      out.write("</a><br>\n");
      out.write("        <font size=\"6\">Ausgewählte Ebene: </font><br>\n");
      out.write("        Bezeichnung: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${floor.getBezeichnung()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("<br>\n");
      out.write("        Bemerkung: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${floor.getBemerkung()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("<br>\n");
      out.write("        <form id=\"form\" name=\"DeleteFloorForm\" action=\"DeleteFloorServlet\">\n");
      out.write("            <input type=\"button\" value=\"Ebene löschen\" name=\"delete\" onclick=\"confirmation()\"/><br>\n");
      out.write("        </form>\n");
      out.write("        <a href=\"createRoom.jsp\">Raum hinzufügen</a><br>\n");
      out.write("        <a href=\"chooseRoom.jsp\">Raum auswählen</a><br>\n");
      out.write("        <a href=\"displayCustomer.jsp\">Kunden anzeigen</a><br>\n");
      out.write("        <a href=\"displayBuilding.jsp\">Gebäude anzeigen</a><br>\n");
      out.write("        <a href=\"index.jsp\">Zurück zum Hauptmenü</a> \n");
      out.write("        \n");
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
