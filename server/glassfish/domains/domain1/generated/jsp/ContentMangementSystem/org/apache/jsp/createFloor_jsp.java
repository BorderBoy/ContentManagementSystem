package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import scrumm.models.Floor;
import scrumm.models.Customer;

public final class createFloor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Ebene erstellen</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Floor floor;
            if(Customer.currentCustomer.getCurrentBuilding().getCurrentFloor() != null){
                floor = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor();
                request.setAttribute("headline", "Ebene bearbeiten");
            } else {
                floor = new Floor("Ebene", "enjdg");     
                request.setAttribute("headline", "Ebene erstellen");
            }
            request.setAttribute("floor", floor);
        
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function check() {\n");
      out.write("                var bez = document.getElementById(\"bez\").value;\n");
      out.write("                if(bez !== \"\"){\n");
      out.write("                    document.getElementById(\"form\").submit();\n");
      out.write("                } else {\n");
      out.write("                    alert(\"ey bezeichnung\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <a href=\"index.jsp\">Home</a>\n");
      out.write("        <a href=\"displayCustomer.jsp\">");
 out.print(" > " + Customer.currentCustomer.getBezeichnung()); 
      out.write("</a>\n");
      out.write("        <a href=\"displayBuidling.jsp\">");
 out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getBezeichnung()); 
      out.write("</a><br>\n");
      out.write("        <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${headline}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\n");
      out.write("        <form id=\"form\" name=\"CreateFloorForm\" action=\"CreateFloorServlet\"> \n");
      out.write("            Bezeichnung: <input id=\"bez\" type=\"text\" name=\"bezeichnung\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${floor.getBezeichnung()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"  /><br>\n");
      out.write("            Bemerkung: <input type=\"text\" name=\"bemerkung\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${floor.getBemerkung()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
