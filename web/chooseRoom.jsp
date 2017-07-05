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
    <body>
        <%
            ArrayList<Room> roomList = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getRaeume();
            request.setAttribute("roomList", roomList);
        %>
        
        <form name="ChoosenRoomForm" action="ChoosenRoomServlet">
            <label>Raum auswählen:<br>
                <script type="text/javascript">
                    function SelectedValue(sel) {                            
                        document.getElementById("submit").removeAttribute('disabled');
                    }
                    function DoubleClicked (){
                         document.getElementById("submit").click();
                    }
                
                </script>
               
                <select name="room" size="${roomList.size()}" ondblclick="DoubleClicked()" onclick="SelectedValue(this)">
                <c:forEach items="${roomList}" var="item" varStatus="theCount">
                   <option value="${theCount.index}">${item.getBezeichnung()}</option>
                </c:forEach>
                 </select>
            </label>
                <br><br><input disabled id="submit" type="submit" value="Auswählen" name="submit" />
       </form>   
        
        
    </body>
</html>

