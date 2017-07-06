<%-- 
    Document   : createBuilding
    Created on : 05.07.2017, 04:16:46
    Author     : Uli
--%>

<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gebäude erstellen</title>
    </head>
    <body>
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
        <h1>Gebäude erstellen</h1>
        <form id="form" name="CreateBulidingForm" action="CreateBuildingServlet"> 
            Bezeichnung: <input id="bez" type="text" name="bezeichnung" value="Haus" /><br>
            Adresse: <input type="text" name="adresse" value="Strasse 1" /><br>
            PLZ: <input id="plz" type="text" name="plz" value="777" /><br>
            Ort: <input type="text" name="ort" value="Stadt" /><br>
            Bemerkung: <input type="text" name="bemerkung" value="enjadg" /><br>
            <input type="button" value="Fertig" name="submitButton" onclick="check()"/><br>
        </form>
    </body>
</html>
