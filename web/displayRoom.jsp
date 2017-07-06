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
        <script type="text/javascript">
                function confirmation(){
                    if(confirm("safe?")){
                        document.getElementById("form").submit();
                    } 
                }
        </script>
        <a href="index.jsp">Home</a>
        <a href="displayCustomer.jsp"><% out.print(" > " + Customer.currentCustomer.getBezeichnung()); %></a>
        <a href="displayBuilding.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getBezeichnung()); %></a>
        <a href="displayFloor.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getBezeichnung()); %></a><br>
        <h1>Ausgewählter Raum: </h1>
        Bezeichnung: ${room.getBezeichnung()}<br>
        Raumnummer: ${room.getRaumnummer()}<br>
        <form id="form" name="DeleteRoomForm" action="DeleteRoomServlet">
            <input type="button" value="Raum löschen" name="delete" onclick="confirmation()"/><br>
        </form>
        <a href="createDevice.jsp">Gerät hinzufügen</a><br>
        <a href="chooseDevice.jsp">Gerät auswählen</a><br>
        <a href="displayCustomer.jsp">Kunden anzeigen</a><br>
        <a href="displayBuilding.jsp">Gebäude anzeigen</a><br>
        <a href="displayFloor.jsp">Ebene anzeigen</a><br>
        <a href="index.jsp">Zurück zum Hauptmenü</a>
    </body>
</html>
