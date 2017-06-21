<%-- 
    Document   : displayCustomer
    Created on : 21.06.2017, 03:16:09
    Author     : ninacordes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="customerBean" scope="request" class="scrumm.models.Customer" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Sie haben sich mit folgendem Kunden angelegt: <br>
        Bezeichnung: <jsp:getProperty name="customerBean" property="bezeichnung" /> <br>
        Adresse:  <jsp:getProperty name="customerBean" property="adresse" /> <br>
        PLZ:  <jsp:getProperty name="customerBean" property="plz" /> <br>
        Ort: <jsp:getProperty name="customerBean" property="ort" /> <br>
        Vorname:  <jsp:getProperty name="customerBean" property="vorname" /> <br>
        Nachname: <jsp:getProperty name="customerBean" property="nachname" /> <br>
        Telefon:  <jsp:getProperty name="customerBean" property="telefonnummer" /> <br>
        Bemerkung: <jsp:getProperty name="customerBean" property="bemerkung" /> <br>
        
        <a href="createBuilding.html">Gebäude hinzufügen</a>
    </body>
</html>
