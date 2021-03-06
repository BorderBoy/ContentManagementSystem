<%-- 
    Document   : chooseBuilding
    Created on : 03.07.2017, 23:28:36
    Author     : Jonas
--%>

<%@page import="java.util.Collections"%>
<%@page import="scrumm.models.Building"%>
<%@page import="java.util.ArrayList"%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gebäude auswählen</title>
    </head>
    <body onload="initialize()">
        <%
            ArrayList<Building> buildingList = Customer.currentCustomer.getGebaeude();
            Collections.sort(buildingList);
            request.setAttribute("buildingList", buildingList);
        %>
        <a href="index.jsp">Home</a>
        <a href="displayCustomer.jsp"><% out.println(" > " + Customer.currentCustomer.getBezeichnung()); %></a><br>

        <h1>Gebäude auswählen</h1>

        <form name="ChoosenBuildingForm" action="ChoosenBuildingServlet">  
            
            <p id="message"></p>
            <a href="displayCustomer.jsp"><p id="linkMessage"></p></a>
            
            
            <script type="text/javascript">
                function SelectedValue(sel) {
                    document.getElementById("submit").removeAttribute('disabled');
                }
                function DoubleClicked() {
                    document.getElementById("submit").click();
                }
                function initialize() {
                    <% ArrayList<String> list = (ArrayList<String>) request.getAttribute("buildingList");
                        int size = list.size();%>
                    var sizee = "<%= size%>";
                    if (sizee != 0) {
                        document.getElementById("list").removeAttribute('disabled');
                        document.getElementById("list").removeAttribute('hidden');
                    } else {
                        document.getElementById("message").innerHTML = "nix Gebäude";
                        document.getElementById("linkMessage").innerHTML = "Zurück zum Kunden";
                    }
                }

            </script>

            <select id="list" disabled="true" hidden="true" name="building" size="${buildingList.size()}" ondblclick="DoubleClicked()" onclick="SelectedValue(this)">
                <c:forEach items="${buildingList}" var="item" varStatus="theCount">
                    <option value="${theCount.index}">${item.getBezeichnung()}</option>
                </c:forEach>
            </select>
            <br><br><input disabled id="submit" type="submit" value="Auswählen" name="submit" />
        </form>   


    </body>
</html>
