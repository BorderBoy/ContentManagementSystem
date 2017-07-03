package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class displayCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      scrumm.models.Customer customerBean = null;
      synchronized (request) {
        customerBean = (scrumm.models.Customer) _jspx_page_context.getAttribute("customerBean", PageContext.REQUEST_SCOPE);
        if (customerBean == null){
          try {
            customerBean = (scrumm.models.Customer) java.beans.Beans.instantiate(this.getClass().getClassLoader(), "scrumm.models.Customer");
          } catch (ClassNotFoundException exc) {
            throw new InstantiationException(exc.getMessage());
          } catch (Exception exc) {
            throw new ServletException("Cannot create bean of class " + "scrumm.models.Customer", exc);
          }
          _jspx_page_context.setAttribute("customerBean", customerBean, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Kunde</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        Sie haben sich mit folgendem Kunden angelegt: <br>\n");
      out.write("        Bezeichnung: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((scrumm.models.Customer)_jspx_page_context.findAttribute("customerBean")).getBezeichnung())));
      out.write(" <br>\n");
      out.write("        Adresse:  ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((scrumm.models.Customer)_jspx_page_context.findAttribute("customerBean")).getAdresse())));
      out.write(" <br>\n");
      out.write("        PLZ:  ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((scrumm.models.Customer)_jspx_page_context.findAttribute("customerBean")).getPlz())));
      out.write(" <br>\n");
      out.write("        Ort: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((scrumm.models.Customer)_jspx_page_context.findAttribute("customerBean")).getOrt())));
      out.write(" <br>\n");
      out.write("        Vorname:  ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((scrumm.models.Customer)_jspx_page_context.findAttribute("customerBean")).getVorname())));
      out.write(" <br>\n");
      out.write("        Nachname: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((scrumm.models.Customer)_jspx_page_context.findAttribute("customerBean")).getNachname())));
      out.write(" <br>\n");
      out.write("        Telefon:  ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((scrumm.models.Customer)_jspx_page_context.findAttribute("customerBean")).getTelefonnummer())));
      out.write(" <br>\n");
      out.write("        Bemerkung: ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((scrumm.models.Customer)_jspx_page_context.findAttribute("customerBean")).getBemerkung())));
      out.write(" <br>\n");
      out.write("        \n");
      out.write("        <a href=\"createBuilding.html\">Gebäude hinzufügen</a>\n");
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
