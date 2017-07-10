<%-- 
    Document   : createBuilding
    Created on : 05.07.2017, 04:16:46
    Author     : Uli
--%>

<%@page import="scrumm.models.Building"%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gebäude erstellen</title>
    </head>
    <body>
        <%
            Building building;
            if(Customer.currentCustomer.getCurrentBuilding() != null){
                building = Customer.currentCustomer.getCurrentBuilding();
                request.setAttribute("headline", "Gebäude bearbeiten");
            } else {
                building = new Building("haus", "Strasse 1", 777, "Stadt", "jaskfsk");                
                request.setAttribute("headline", "Gebäude erstellen");
            }
            request.setAttribute("building", building);
        %>
        
        <script type="text/javascript">
            function check() {
               var data = document.getElementById("plz").value;
               console.log(parseInt(data));
               if(!isNaN(data)) {
                   var bez = document.getElementById("bez").value;
                   if(bez !== ""){
                       document.getElementById("form").submit();
                   } else {
                       alert("ey bezeichnung");
                   }
               } else {
                   alert("plz nummer!");
               }

            }
        </script>
        <a href="index.jsp">Home</a>
        <a href="displayCustomer.jsp"><% out.println(" > " + Customer.currentCustomer.getBezeichnung()); %></a><br>
        <h1>${headline}</h1>
        <form id="form" name="CreateBulidingForm" action="CreateBuildingServlet"> 
            Bezeichnung: <input id="bez" type="text" name="bezeichnung" value="${building.getBezeichnung()}" /><br>
            Adresse: <input type="text" name="adresse" value="${building.getAdresse()}" /><br>
            PLZ: <input id="plz" type="text" name="plz" value="${building.getPlz()}" /><br>
            Ort: <input type="text" name="ort" value="${building.getOrt()}" /><br>
            Bemerkung: <input type="text" name="bemerkung" value="${building.getBemerkung()}" /><br>
            <input type="button" value="Fertig" name="submitButton" onclick="check()"/><br>
        </form>
    </body>
</html>
