<%-- 
    Document   : displayCustomer
    Created on : 21.06.2017, 03:16:09
    Author     : ninacordes
--%>

<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kunde anzeigen</title>
    </head>
    <body>
        <%
            Customer customer = Customer.currentCustomer;
            request.setAttribute("customer", customer);
        %>
        
        <script type="text/javascript">
                function confirmation(){
                    if(confirm("Kunde weg?")){
                        document.getElementById("form").submit();
                    } 
                }
        </script>
        
        Ausgewählter Kunde: <br>
        Bezeichnung: ${customer.getBezeichnung()}<br>
        Adresse: ${customer.getAdresse()}<br>
        PLZ: ${customer.getPlz()}<br>
        Ort: ${customer.getOrt()}<br>
        Vorname: ${customer.getVorname()}<br>
        Nachname: ${customer.getNachname()}<br>
        Telefon: ${customer.getTelefonnummer()}<br>
        Bemerkung: ${customer.getBemerkung()}<br>
        
       
        <form id="form" name="DeleteCustomerForm" action="DeleteCustomerServlet">
            <input type="button" value="Kunden löschen" name="delete" onclick="confirmation()"/><br>
        </form>
        <a href="createBuilding.jsp">Gebäude hinzufügen</a><br>
        <a href="chooseBuilding.jsp">Gebäude auswählen</a><br>
        <a href="index.jsp">Zurück zum Hauptmenü</a>
    </body>
    
</html>
