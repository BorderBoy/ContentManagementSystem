<%-- 
    Document   : displayFloor
    Created on : 04.07.2017, 02:19:31
    Author     : Jonas
--%><%@page import="scrumm.models.Floor"%>



<%@page import="scrumm.models.Building"%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ebene anzeigen</title>
    </head>
    <body>
       <%
            Floor floor = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor();
            request.setAttribute("floor", floor);
            Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().setCurrentRoom(null);
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
        <a href="displayBuilding.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getBezeichnung()); %></a><br>
        
        <h1>Ausgewählte Ebene: </h1>
        
        Bezeichnung: ${floor.getBezeichnung()}<br>
        Bemerkung: ${floor.getBemerkung()}<br>
        <form id="form" name="DeleteFloorForm" action="DeleteFloorServlet">
            <input type="button" value="Ebene löschen" name="delete" onclick="confirmation()"/><br>
        </form>
        <a href="createFloor.jsp">Ebene bearbeiten</a><br>
        <a href="createRoom.jsp">Raum hinzufügen</a><br>
        <a href="chooseRoom.jsp">Raum auswählen</a><br>
        <a href="displayCustomer.jsp">Kunden anzeigen</a><br>
        <a href="displayBuilding.jsp">Gebäude anzeigen</a><br>
        <a href="index.jsp">Zurück zum Hauptmenü</a> 
        
    </body>
</html>
