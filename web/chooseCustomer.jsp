<%-- 
    Document   : chooseCustomer
    Created on : 26.06.2017, 19:08:32
    Author     : Jonas
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="customerListBean" scope="request" class="java.util.ArrayList" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kunden auswählen</title>
    </head>
    <body>
        <%
            //ArrayList<String> list = (ArrayList) session.getAttribute("customerListBean");

            //ArrayList<String> list = new ArrayList<String>();
            //out.println(list.getList().get(0));
            //list is empty!!!
            //liste übergeben aus chooscustomerservlet
            
        %>
         
       <form name="ChoosenCustomerForm" action="ChoosenCustomerServlet">
            <label>Kunden auswählen:<br>
                <select name="customer" size="${customerListBean.size()}">
                <c:forEach items="${customerListBean}" var="item">
                   <option value="${item[0]}">${item[0]}: ${item[1]}</option>
                </c:forEach>
                 </select>
            </label>
            <br><br><input type="submit" value="Auswählen" name="submit" />
       </form>     
       
        
    </body>
</html>
