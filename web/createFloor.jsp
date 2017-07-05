<%-- 
    Document   : createFloor
    Created on : 05.07.2017, 04:46:54
    Author     : Uli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ebene erstellen</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
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
        <form id="form" name="CreateFloorForm" action="CreateFloorServlet"> 
            Bezeichnung: <input id="bez" type="text" name="bezeichnung" value="Ebene"  /><br>
            Bemerkung: <input type="text" name="bemerkung" value="enjdg" /><br>
            <input type="button" value="Fertig" name="submitButton" onclick="check()"/><br>
        </form>
    </body>
</html>
