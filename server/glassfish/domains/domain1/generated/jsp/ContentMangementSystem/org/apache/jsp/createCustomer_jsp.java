package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        <title>Kunde anlegen</title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function check() {\n");
      out.write("               var plz = document.getElementById(\"plz\").value;\n");
      out.write("               if(!isNaN(plz)) {\n");
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
      out.write("         \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        <a href=\"index.jsp\">Home</a><br>\n");
      out.write("        <h1>Kunde erstellen</h1>\n");
      out.write("        <form id=\"form\" name=\"CreateCustomerForm\" action=\"CreateCustomerServlet\">\n");
      out.write("            Bezeichnung: <input id=\"bez\" type=\"text\" name=\"bezeichnung\" value=\"Uaschluch\" /><br>\n");
      out.write("            Adresse: <input type=\"text\" name=\"adresse\" value=\"Disney Land\" /><br>\n");
      out.write("            PLZ: <input id=\"plz\" type=\"text\" name=\"plz\" value=\"666\" /><br>\n");
      out.write("            Ort: <input type=\"text\" name=\"ort\" value=\"a\" /><br>\n");
      out.write("            Vorname: <input type=\"text\" name=\"vorname\" value=\"eooj j\" /><br>\n");
      out.write("            Nachname: <input type=\"text\" name=\"nachname\" value=\"eooj j\" /><br>\n");
      out.write("            Telefon: <input type=\"text\" name=\"telefonnummer\" value=\"eooj j\" /><br>\n");
      out.write("            Bemerkung: <input type=\"text\" name=\"bemerkung\" value=\"eooj j\" /><br>\n");
      out.write("            <input type=\"button\" value=\"Fertig\" name=\"submitButton\" onclick=\"check()\"/>\n");
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
