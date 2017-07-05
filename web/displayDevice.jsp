<%-- 
    Document   : displayDevice
    Created on : 05.07.2017, 03:01:21
    Author     : Uli
--%>

<%@page import="scrumm.models.Device"%>
<%@page import="scrumm.models.Room"%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerät anzeigen</title>
    </head>
    <body>
        <%
            Device device = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getCurrentDevice();
            request.setAttribute("device", device);
        %>
        Ausgewähltes Gerät: <br>
        Bezeichnung: ${device.getBezeichnung()}<br>
        ID: ${device.getId()}<br>
        Klasse: ${device.getKlasse()}<br>
        <a href="displayCustomer.jsp">Kunden anzeigen</a><br>
        <a href="displayBuilding.jsp">Gebäude anzeigen</a><br>
        <a href="displayFloor.jsp">Ebene anzeigen</a><br>
        <a href="displayRoom.jsp">Raum anzeigen</a><br>
        <a href="index.jsp">Zurück zum Hauptmenü</a>
    </body>
</html>
