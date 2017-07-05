<%-- 
    Document   : chooseDevice
    Created on : 05.07.2017, 03:08:02
    Author     : Uli
--%>

<%@page import="scrumm.models.Device"%>
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
        <title>Gerät auswählen</title>
    </head>
    <body onload="initialize()">
        <%
            ArrayList<Device> deviceList = Customer.currentCustomer.getCurrentBuilding().getCurrentFloor().getCurrentRoom().getGeraete();
            request.setAttribute("deviceList", deviceList);
        %>
        
        <form name="ChoosenDeviceForm" action="ChoosenDeviceServlet">
            <label>Gerät auswählen:<br>
                <script type="text/javascript">
                    function SelectedValue(sel) {                            
                        document.getElementById("submit").removeAttribute('disabled');
                    }
                    function DoubleClicked (){
                         document.getElementById("submit").click();
                    }
                    function initialize(){
                        <% ArrayList<String> list = (ArrayList<String>) request.getAttribute("deviceList"); 
                        int size = list.size(); %>
                        var sizee = "<%= size%>";
                        if(sizee!=0){
                            document.getElementById("list").removeAttribute('disabled');
                            document.getElementById("list").removeAttribute('hidden');
                        } else {
                            document.write("nix Gerät"); 
                        }
                    }
                
                </script>
               
                <select  id="list" disabled="true" hidden="true" name="device" size="${deviceList.size()}" ondblclick="DoubleClicked()" onclick="SelectedValue(this)">
                <c:forEach items="${deviceList}" var="item" varStatus="theCount">
                   <option value="${theCount.index}">${item.getBezeichnung()}</option>
                </c:forEach>
                 </select>
            </label>
                <br><br><input disabled id="submit" type="submit" value="Auswählen" name="submit" />
       </form>   
        
        
    </body>
</html>
