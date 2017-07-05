<%-- 
    Document   : createRoom
    Created on : 05.07.2017, 05:02:36
    Author     : Uli
--%>

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
        <form id="form" name="CreateRoomForm" action="CreateRoomServlet"> 
            Bezeichnung: <input id="bez" type="text" name="bezeichnung" value="Raum" /><br>
            Raumnummer: <input type="text" name="raumnummer" value="684648.684694" id="raumnr" /><br>
            <input type="button" value="Fertig" name="submitButton" onclick="check()" /><br>
        </form>
    </body>
</html>
