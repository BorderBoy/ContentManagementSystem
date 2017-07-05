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
        
        <script type="text/javascript">
                function confirmation(){
                    if(confirm("safe?")){
                        document.getElementById("form").submit();
                    }                     
                    
                }
        </script>
        <a href="displayCustomer.jsp"><% out.print(Customer.currentCustomer.getBezeichnung()); %></a>
        <a href="displayBuilding.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getBezeichnung()); %></a>
        <a href="displayFloor.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getBezeichnung()); %></a>
        <a href="displayRoom.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getBezeichnung()); %></a><br>
        <font size="6">Ausgewähltes Gerät: </font><br>
        Bezeichnung: ${device.getBezeichnung()}<br>
        ID: ${device.getId()}<br>
        Klasse: ${device.getKlasse()}<br>
        <form id="form" name="DeleteDeviceForm" action="DeleteDeviceServlet">
            <input type="button" value="Gerät löschen" name="delete" onclick="confirmation()"/><br>
        </form>
        <a href="displayCustomer.jsp">Kunden anzeigen</a><br>
        <a href="displayBuilding.jsp">Gebäude anzeigen</a><br>
        <a href="displayFloor.jsp">Ebene anzeigen</a><br>
        <a href="displayRoom.jsp">Raum anzeigen</a><br>
        <a href="index.jsp">Zurück zum Hauptmenü</a>
    </body>
</html>
