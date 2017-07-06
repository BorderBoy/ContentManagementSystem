<%-- 
    Document   : index
    Created on : 03.07.2017, 23:13:36
    Author     : Jonas
--%>

<%@page import="scrumm.models.Building"%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->


<html>
    <head>
        <title>Content Management System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            Customer.setCurrentCustomer(null);
        %>
        <h1>Content Management System</h1>
        <a href="createCustomer.jsp">Neuen Kunden anlegen</a> <br>
        <a href="chooseCustomer.jsp">Kunden auswählen</a>
        <form name="ImportReadingsForm" action="ImportReadingsServlet">
            <input type="submit" value="Messdaten einlesen" name="submit" />
        </form>
    </body>
</html>

