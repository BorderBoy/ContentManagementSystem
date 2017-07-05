<%-- 
    Document   : displayRoom
    Created on : 05.07.2017, 01:47:34
    Author     : Uli
--%>

<%@page import="scrumm.models.Room"%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Raum anzeigen</title>
    </head>
    <body>
        <%
            Room room = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom();
            request.setAttribute("room", room);
        %>
        Aktueller Raum: <br>
        Bezeichnung: ${room.getBezeichnung()}<br>
        Raumnummer: ${room.getRaumnummer()}<br>
        <a href="createDevice.html">Gerät hinzufügen</a><br>
        <a href="displayCustomer.jsp">Kunden anzeigen</a><br>
        <a href="displayBuilding.jsp">Gebäude anzeigen</a><br>
        <a href="displayFloor.jsp">Ebene anzeigen</a><br>
        <a href="index.jsp">Zurück zum Hauptmenü</a>
    </body>
</html>
