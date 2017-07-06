<%-- 
    Document   : createRoom
    Created on : 05.07.2017, 05:02:36
    Author     : Uli
--%>

<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <title>Raum erstellen</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
    </head>
    <body>
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
        <h1>Raum erstellen</h1>
        <form id="form" name="CreateRoomForm" action="CreateRoomServlet"> 
            Bezeichnung: <input id="bez" type="text" name="bezeichnung" value="Raum" /><br>
            Raumnummer: <input type="text" name="raumnummer" value="684648.684694" id="raumnr" /><br>
            <input type="button" value="Fertig" name="submitButton" onclick="check()" /><br>
        </form>
    </body>
</html>
