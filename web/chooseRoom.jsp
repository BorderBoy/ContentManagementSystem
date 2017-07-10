<%-- 
    Document   : chooseRoom
    Created on : 05.07.2017, 02:04:24
    Author     : Uli
--%>

<%@page import="scrumm.models.Room"%>
<!DOCTYPE html>
<%@page import="scrumm.models.Floor"%>
<%@page import="scrumm.models.Building"%>
<%@page import="java.util.ArrayList"%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Raum auswählen</title>
    </head>
    <body onload="initialize()">
        <%
            ArrayList<Room> roomList = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getRaeume();
            request.setAttribute("roomList", roomList);
        %>
        <a href="index.jsp">Home</a>
        <a href="displayCustomer.jsp"><% out.print(" > " + Customer.currentCustomer.getBezeichnung()); %></a>
        <a href="displayBuilding.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getBezeichnung()); %></a>
        <a href="displayFloor.jsp"><% out.print(" > " + Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getBezeichnung()); %></a><br>
        
        <h1>Raum auswählen</h1>
        
        <form name="ChoosenRoomForm" action="ChoosenRoomServlet">
            
            <p id="message"></p>
            <a href="displayFloor.jsp"><p id="linkMessage"></p></a>
            

            <script type="text/javascript">
                function SelectedValue(sel) {
                    document.getElementById("submit").removeAttribute('disabled');
                }
                function DoubleClicked() {
                    document.getElementById("submit").click();
                }
                function initialize() {
                       <% ArrayList<String> list = (ArrayList<String>) request.getAttribute("roomList");
                    int size = list.size();%>
                    var sizee = "<%= size%>";
                    if (sizee != 0) {
                        document.getElementById("list").removeAttribute('disabled');
                        document.getElementById("list").removeAttribute('hidden');
                    } else {
                        document.getElementById("message").innerHTML = "nix Raum";
                        document.getElementById("linkMessage").innerHTML = "Zurück zur Ebene";
                    }
                }
            </script>

            <select id="list" disabled="true" hidden="true" name="room" size="${roomList.size()}" ondblclick="DoubleClicked()" onclick="SelectedValue(this)">
                <c:forEach items="${roomList}" var="item" varStatus="theCount">
                    <option value="${theCount.index}">${item.getBezeichnung()}</option>
                </c:forEach>
            </select>
            <br><br><input disabled id="submit" type="submit" value="Auswählen" name="submit" />
        </form>   


    </body>
</html>

