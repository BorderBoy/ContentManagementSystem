<%-- 
    Document   : createDevice
    Created on : 05.07.2017, 05:13:26
    Author     : Uli
--%>

<%@page import="scrumm.models.Device"%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerät erstellen</title>
    </head>
    <body>
        <%
            Device device;
            if(Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getCurrentDevice() != null){
                device = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getCurrentDevice();
                request.setAttribute("enabled", "disabled");
                if(device.getKlasse() == 1){
                    request.setAttribute("checked1", "checked");
                    request.setAttribute("checked2", "");
                } else {
                    request.setAttribute("checked1", "");
                    request.setAttribute("checked2", "checked");                
                }
                
                request.setAttribute("headline", "Gerät bearbeiten");
                
            } else {
                device = new Device("gerääät", 1);
                request.setAttribute("enabled", "");
                request.setAttribute("checked1", "checked");
                request.setAttribute("checked2", "");
                request.setAttribute("headline", "Gerät erstellen");
            }
            request.setAttribute("device", device);
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
        <a href="displayBuilding.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getBezeichnung()); %></a>
        <a href="displayFloor.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getBezeichnung()); %></a>
        <a href="displayRoom.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getBezeichnung()); %></a><br>
        <h1>${headline}</h1>
        <form id="form" name="CreateDeviceForm" action="CreateDeviceServlet"> 
            Bezeichnung: <input type="text" name="bezeichnung" value="${device.getBezeichnung()}" id="bez" /><br>
            <!--ID: <input type="text" name="id" value="1209" /><br>-->
            Klasse: <br>
            <input ${enabled} type="radio" name="klasse" value="1" ${checked1} /> 1 <br>
            <input ${enabled} type="radio" name="klasse" value="2" ${checked2}/> 2 <br>
            <input type="button" value="Fertig" name="submitButton" onclick="check()" /><br>
        </form>
    </body>
</html>
