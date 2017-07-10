package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import scrumm.models.Building;
import scrumm.models.Customer;

public final class createBuilding_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Gebäude erstellen</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Building building;
            if(Customer.currentCustomer.getCurrentBuilding() != null){
                building = Customer.currentCustomer.getCurrentBuilding();
                request.setAttribute("headline", "Gebäude bearbeiten");
            } else {
                building = new Building("haus", "Strasse 1", 777, "Stadt", "jaskfsk");                
                request.setAttribute("headline", "Gebäude erstellen");
            }
            request.setAttribute("building", building);
        
      out.write("\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function check() {\n");
      out.write("               var data = document.getElementById(\"plz\").value;\n");
      out.write("               console.log(parseInt(data));\n");
      out.write("               if(!isNaN(data)) {\n");
      out.write("                   var bez = document.getElementById(\"bez\").value;\n");
      out.write("                   if(bez !== \"\"){\n");
      out.write("                       document.getElementById(\"form\").submit();\n");
      out.write("                   } else {\n");
      out.write("                       alert(\"ey bezeichnung\");\n");
      out.write("                   }\n");
      out.write("               } else {\n");
      out.write("                   alert(\"plz nummer!\");\n");
      out.write("               }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <a href=\"index.jsp\">Home</a>\n");
      out.write("        <a href=\"displayCustomer.jsp\">");
 out.println(" > " + Customer.currentCustomer.getBezeichnung()); 
      out.write("</a><br>\n");
      out.write("        <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${headline}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\n");
      out.write("        <form id=\"form\" name=\"CreateBulidingForm\" action=\"CreateBuildingServlet\"> \n");
      out.write("            Bezeichnung: <input id=\"bez\" type=\"text\" name=\"bezeichnung\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${building.getBezeichnung()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /><br>\n");
      out.write("            Adresse: <input type=\"text\" name=\"adresse\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${building.getAdresse()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /><br>\n");
      out.write("            PLZ: <input id=\"plz\" type=\"text\" name=\"plz\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${building.getPlz()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /><br>\n");
      out.write("            Ort: <input type=\"text\" name=\"ort\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${building.getOrt()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /><br>\n");
      out.write("            Bemerkung: <input type=\"text\" name=\"bemerkung\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${building.getBemerkung()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /><br>\n");
      out.write("            <input type=\"button\" value=\"Fertig\" name=\"submitButton\" onclick=\"check()\"/><br>\n");
      out.write("        </form>\n");
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
