<%-- 
    Document   : chooseFloor
    Created on : 04.07.2017, 02:31:04
    Author     : Jonas
--%>

<%@page import="scrumm.models.Floor"%>
<%@page import="scrumm.models.Building"%>
<%@page import="java.util.ArrayList"%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ebene auswählen</title>
    </head>
    <body onload="initialize()">
        <%
            ArrayList<Floor> floorList = Customer.currentCustomer.getCurrentBuilding().getEbenen();
            request.setAttribute("floorList", floorList);
        %>
        
        <form name="ChoosenFloorForm" action="ChoosenFloorServlet">
            <label>Ebene auswählen:<br>
                <script type="text/javascript">
                    function SelectedValue(sel) {                            
                        document.getElementById("submit").removeAttribute('disabled');
                    }
                    function DoubleClicked (){
                         document.getElementById("submit").click();
                    }
                    function initialize(){
                        <% ArrayList<String> list = (ArrayList<String>) request.getAttribute("floorList"); 
                        int size = list.size(); %>
                        var sizee = "<%= size%>";
                        if(sizee!=0){
                            document.getElementById("list").removeAttribute('disabled');
                            document.getElementById("list").removeAttribute('hidden');
                        } else {
                            document.write("nix Ebene"); 
                        }
                    }
                </script>
               
                <select id="list" disabled="true" hidden="true" name="floor" size="${floorList.size()}" ondblclick="DoubleClicked()" onclick="SelectedValue(this)">
                <c:forEach items="${floorList}" var="item" varStatus="theCount">
                   <option value="${theCount.index}">${item.getBezeichnung()}</option>
                </c:forEach>
                 </select>
            </label>
                <br><br><input disabled id="submit" type="submit" value="Auswählen" name="submit" />
       </form>   
        
        
    </body>
</html>
