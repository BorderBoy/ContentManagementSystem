<%-- 
    Document   : createRoom
    Created on : 05.07.2017, 05:02:36
    Author     : Uli
--%>

<%@page import="scrumm.models.Room"%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <title>Raum erstellen</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
    </head>
    <body>
        <%
            Room room;
            if(Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom() != null){
                room = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom();
                request.setAttribute("headline", "Raum bearbeiten");
            } else {
                room = new Room("Raum", "68486.185");     
                request.setAttribute("headline", "Raum erstellen");
            }
            request.setAttribute("room", room);
        %>
        <script type="text/javascript">
           function check() {
               var bez = document.getElementById("bez").value;
               var raumnr = document.getElementById("raumnr").value;
               if(bez !== "" || raumnr !==""){
                   document.getElementById("form").submit();
               } else {
                   alert("ey bezeichnung oder nummer");
               }
           }
        </script> 
        <a href="index.jsp">Home</a>
        <a href="displayCustomer.jsp"><% out.print(" > " + Customer.currentCustomer.getBezeichnung()); %></a>
        <a href="displayBuilding.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getBezeichnung()); %></a>
        <a href="displayFloor.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getBezeichnung()); %></a><br>
        <h1>${headline}</h1>
        <form id="form" name="CreateRoomForm" action="CreateRoomServlet"> 
            Bezeichnung: <input id="bez" type="text" name="bezeichnung" value="${room.getBezeichnung()}" /><br>
            Raumnummer: <input type="text" name="raumnummer" value="${room.getRaumnummer()}" id="raumnr" /><br>
            <input type="button" value="Fertig" name="submitButton" onclick="check()" /><br>
        </form>
    </body>
</html>
