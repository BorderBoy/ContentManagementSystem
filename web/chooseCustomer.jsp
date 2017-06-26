<%-- 
    Document   : chooseCustomer
    Created on : 26.06.2017, 19:08:32
    Author     : Jonas
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="customerListBean" scope="page" class="java.util.ArrayList" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kunden auswählen</title>
    </head>
    <body>
        <%
            ArrayList<String> list = (ArrayList) session.getAttribute("customerListBean");
            System.out.println(list.get(0));
            //list is empty!!!
            //liste übergeben aus chooscustomerservlet
            
        %>
            
        <c:forEach items="${list}" var="item">
             ${item}<br>
        </c:forEach>
    </body>
</html>
