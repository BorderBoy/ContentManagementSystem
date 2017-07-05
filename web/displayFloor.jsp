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
        %>
        <script type="text/javascript">
        function confirmation(){
                    if(confirm("safe?")){
                        document.getElementById("form").submit();
                    } 
                }
        </script>
        Ausgewählte Ebene: <br>
        Bezeichnung: ${floor.getBezeichnung()}<br>
        Bemerkung: ${floor.getBemerkung()}<br>
        <form id="form" name="DeleteFloorForm" action="DeleteFloorServlet">
            <input type="button" value="Ebene löschen" name="delete" onclick="confirmation()"/><br>
        </form>
        <a href="createRoom.jsp">Raum hinzufügen</a><br>
        <a href="chooseRoom.jsp">Raum auswählen</a><br>
        <a href="displayCustomer.jsp">Kunden anzeigen</a><br>
        <a href="displayBuilding.jsp">Gebäude anzeigen</a><br>
        <a href="index.jsp">Zurück zum Hauptmenü</a> 
        
    </body>
</html>
