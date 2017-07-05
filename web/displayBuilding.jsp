<%-- 
    Document   : displayBuilding
    Created on : 03.07.2017, 23:18:41
    Author     : Jonas
--%>

<%@page import="scrumm.models.Building"%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gebäude anzeigen</title>
    </head>
    <body>
        <%
            Building building = Customer.currentCustomer.getCurrentBuilding();
            request.setAttribute("building", building);
        %>
        
        <script type="text/javascript">
            function confirmation(){
                if(window.confirm("safe?")){
                    document.getElementById("form").submit();
                }
            }
        </script>    
        
        Ausgewähltes Gebäude: <br>
        Bezeichnung: ${building.getBezeichnung()}<br>
        Adresse: ${building.getAdresse()}<br>
        PLZ: ${building.getPlz()}<br>
        Ort: ${building.getOrt()}<br>
        Bemerkung: ${building.getBemerkung()}<br>
        <form id="form" name="DeleteBuildingForm" action="DeleteBuildingServlet">
            <input type="button" value="Gebäude löschen" name="delete" onclick="confirmation()"/><br>
        </form>
        <a href="createFloor.jsp">Ebene hinzufügen</a><br>
        <a href="chooseFloor.jsp">Ebene auswählen</a><br>
        <a href="displayCustomer.jsp">Kunden anzeigen</a><br>
        <a href="index.jsp">Zurück zum Hauptmenü</a>
    </body>
</html>
