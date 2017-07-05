<%-- 
    Document   : chooseCustomer
    Created on : 26.06.2017, 19:08:32
    Author     : Jonas
--%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kunden auswählen</title>
    </head>
    <body onload="initialize()">
        
        <% 
            
            ArrayList<String[]> customerList = new ArrayList<String[]>();

            try {
                Connection cn;
                Statement st;
                ResultSet rs;


                Class.forName("org.sqlite.JDBC");
                cn = DriverManager.getConnection("jdbc:sqlite:../../../../../cms.db");
                st = cn.createStatement();  

                rs = st.executeQuery("SELECT * FROM kunde ORDER BY bezeichnung desc");


                while(rs.next()){
                    //customerList.add(new Customer(rs.getString("vorname"), rs.getString("nachname"), rs.getString("bezeichnung"), rs.getString("ort"), rs.getString("adresse"), convertToArrayList(rs.getBytes("gebaeude")), rs.getInt("plz"), rs.getString("telefonnummer"), rs.getString("bemerkung"), rs.getInt("kundenID")));
                    String[] array;
                    array = new String[2];
                    array[0] = rs.getInt("kundenID")+"";
                    array[1] = rs.getString("bezeichnung");
                    customerList.add(array);
                }

                rs.close();
                st.close();
                cn.close();



            } catch (Exception e) {
            }   
            
            request.setAttribute("customerList",customerList);
        %>
       
        
       <form name="ChoosenCustomerForm" action="ChoosenCustomerServlet">
            <label>Kunden auswählen:<br>
                <script type="text/javascript">
                    function SelectedValue(sel) {                            
                        document.getElementById("submit").removeAttribute('disabled');
                     }
                     function DoubleClicked (){
                         document.getElementById("submit").click();
                     }
                    function initialize(){
                        <% ArrayList<String> list = (ArrayList<String>) request.getAttribute("customerList"); 
                        int size = list.size(); %>
                        var sizee = "<%= size%>";
                        if(sizee!=0){
                            document.getElementById("list").removeAttribute('disabled');
                            document.getElementById("list").removeAttribute('hidden');
                        } else {
                            document.write("nix Kunde"); 
                        }
                    }
                </script>
                
                
                <select id="list" name="customer" disabled="true" hidden="true" size="${customerList.size()}"  ondblclick="DoubleClicked()" onclick ="SelectedValue(this)">
                <c:forEach items="${customerList}" var="item">
                   <option value="${item[0]}">${item[0]}: ${item[1]}</option>
                </c:forEach>
                 </select>
            </label>
                
                <br><br><input disabled id="submit" type="submit" value="Auswählen" name="submit" />
            
       </form>    
           
       
        
    </body>
</html>
