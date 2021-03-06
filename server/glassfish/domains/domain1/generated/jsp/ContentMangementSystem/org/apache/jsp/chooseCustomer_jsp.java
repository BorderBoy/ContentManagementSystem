package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public final class chooseCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Kunden auswählen</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"initialize()\">\n");
      out.write("\n");
      out.write("        ");
 //load customer from database

            ArrayList<String[]> customerList = new ArrayList<String[]>();

            try {
                Connection cn;
                Statement st;
                ResultSet rs;

                Class.forName("org.sqlite.JDBC");
                cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");
                st = cn.createStatement();

                rs = st.executeQuery("SELECT * FROM kunde ORDER BY bezeichnung desc");

                while (rs.next()) {
                    String[] array;
                    array = new String[2];
                    array[0] = rs.getInt("kundenID") + "";
                    array[1] = rs.getString("bezeichnung");
                    customerList.add(array);
                }

                rs.close();
                st.close();
                cn.close();

            } catch (Exception e) {
            }

            request.setAttribute("customerList", customerList);
        
      out.write("\n");
      out.write("\n");
      out.write("        <a href=\"index.jsp\">Home</a><br>\n");
      out.write("        <h1>Kunde auswählen</h1>\n");
      out.write("        <form name=\"ChoosenCustomerForm\" action=\"ChoosenCustomerServlet\">\n");
      out.write("\n");
      out.write("            <p id=\"message\"></p>\n");
      out.write("            <a href=\"index.jsp\"><p id=\"linkMessage\"></p></a>\n");
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                function SelectedValue(sel) {\n");
      out.write("                    document.getElementById(\"submit\").removeAttribute('disabled');\n");
      out.write("                }\n");
      out.write("                function DoubleClicked() {\n");
      out.write("                        document.getElementById(\"submit\").click();\n");
      out.write("                }\n");
      out.write("                function initialize() {\n");
      out.write("                    ");

                        ArrayList<String> list = (ArrayList<String>) request.getAttribute("customerList");
                        int size = list.size();
                    
      out.write("\n");
      out.write("                    var sizee = \"");
      out.print( size);
      out.write("\";\n");
      out.write("                    if (sizee != 0) {\n");
      out.write("                        document.getElementById(\"list\").removeAttribute('disabled');\n");
      out.write("                        document.getElementById(\"list\").removeAttribute('hidden');\n");
      out.write("                        document.getElementById(\"submit\").removeAttribute('hidden');\n");
      out.write("                    } else {\n");
      out.write("                        //document.write(\"nix Kunde\"); \n");
      out.write("                        document.getElementById(\"message\").innerHTML = \"nix Kunde\";\n");
      out.write("                        document.getElementById(\"linkMessage\").innerHTML = \"Zurück zum Hauptmenü\";\n");
      out.write("\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <select id=\"list\" name=\"customer\" disabled=\"true\" hidden=\"true\" size=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customerList.size()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"  ondblclick=\"DoubleClicked()\" onclick =\"SelectedValue(this)\">\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </select>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <br><br><input disabled hidden id=\"submit\" type=\"submit\" value=\"Auswählen\" name=\"submit\" /><br>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customerList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("item");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(':');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item[1]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
