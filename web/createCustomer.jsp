<%-- 
    Document   : createCustomer
    Created on : 05.07.2017, 03:35:02
    Author     : Uli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Kunde anlegen</title>
        
    </head>
    <body>
        <script type="text/javascript">
            function check() {
               var plz = document.getElementById("plz").value;
               if(!isNaN(plz)) {
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
        
        <a href="index.jsp">Home</a><br>
        <h1>Kunde erstellen</h1>
        <form id="form" name="CreateCustomerForm" action="CreateCustomerServlet">
            Bezeichnung: <input id="bez" type="text" name="bezeichnung" value="Uaschluch" /><br>
            Adresse: <input type="text" name="adresse" value="Disney Land" /><br>
            PLZ: <input id="plz" type="text" name="plz" value="666" /><br>
            Ort: <input type="text" name="ort" value="a" /><br>
            Vorname: <input type="text" name="vorname" value="eooj j" /><br>
            Nachname: <input type="text" name="nachname" value="eooj j" /><br>
            Telefon: <input type="text" name="telefonnummer" value="eooj j" /><br>
            Bemerkung: <input type="text" name="bemerkung" value="eooj j" /><br>
            <input type="button" value="Fertig" name="submitButton" onclick="check()"/>
        </form>
    </body>
</html>
