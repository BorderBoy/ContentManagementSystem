package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import scrumm.models.Customer;

public final class createRoom_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("   <head>\n");
      out.write("        <title>Raum erstellen</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("           function check() {\n");
      out.write("               var bez = document.getElementById(\"bez\").value;\n");
      out.write("               var raumnr = document.getElementById(\"raumnr\").value;\n");
      out.write("               if(bez !== \"\" || raumnr !==\"\"){\n");
      out.write("                   document.getElementById(\"form\").submit();\n");
      out.write("               } else {\n");
      out.write("                   alert(\"ey bezeichnung oder nummer\");\n");
      out.write("               }\n");
      out.write("           }\n");
      out.write("        </script> \n");
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
      out.write("        <h1>Raum erstellen</h1>\n");
      out.write("        <form id=\"form\" name=\"CreateRoomForm\" action=\"CreateRoomServlet\"> \n");
      out.write("            Bezeichnung: <input id=\"bez\" type=\"text\" name=\"bezeichnung\" value=\"Raum\" /><br>\n");
      out.write("            Raumnummer: <input type=\"text\" name=\"raumnummer\" value=\"684648.684694\" id=\"raumnr\" /><br>\n");
      out.write("            <input type=\"button\" value=\"Fertig\" name=\"submitButton\" onclick=\"check()\" /><br>\n");
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