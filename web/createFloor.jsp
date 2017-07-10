<%-- 
    Document   : createFloor
    Created on : 05.07.2017, 04:46:54
    Author     : Uli
--%>

<%@page import="scrumm.models.Floor"%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ebene erstellen</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            Floor floor;
            if(Customer.currentCustomer.getCurrentBuilding().getCurrentFloor() != null){
                floor = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor();
                request.setAttribute("headline", "Ebene bearbeiten");
            } else {
                floor = new Floor("Ebene", "enjdg");     
                request.setAttribute("headline", "Ebene erstellen");
            }
            request.setAttribute("floor", floor);
        %>
        <script type="text/javascript">
            function check() {
                var bez = document.getElementById("bez").value;
                if(bez !== ""){
                    document.getElementById("form").submit();
                } else {
                    alert("ey bezeichnung");
                }
            }
        </script>
        <a href="index.jsp">Home</a>
        <a href="displayCustomer.jsp"><% out.print(" > " + Customer.currentCustomer.getBezeichnung()); %></a>
        <a href="displayBuidling.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getBezeichnung()); %></a><br>
        <h1>${headline}</h1>
        <form id="form" name="CreateFloorForm" action="CreateFloorServlet"> 
            Bezeichnung: <input id="bez" type="text" name="bezeichnung" value="${floor.getBezeichnung()}"  /><br>
            Bemerkung: <input type="text" name="bemerkung" value="${floor.getBemerkung()}" /><br>
            <input type="button" value="Fertig" name="submitButton" onclick="check()"/><br>
        </form>
    </body>
</html>
