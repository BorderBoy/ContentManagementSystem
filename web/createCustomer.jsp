<%-- 
    Document   : createCustomer
    Created on : 05.07.2017, 03:35:02
    Author     : Uli
--%>
<%@page import="scrumm.models.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Kunde anlegen</title>
        
    </head>
    <body>
        <%
            Customer customer;
            if(Customer.currentCustomer != null){
                customer = Customer.currentCustomer;
                request.setAttribute("headline", "Kunden bearbeiten");
            } else {
                customer = new Customer("Uaschluch", "äy", "kundeney", "orts", "Disney LAnd", 666, "01245", "af"); 
                request.setAttribute("headline", "Kunden erstellen");
            }
            request.setAttribute("customer", customer);
        %>
       
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
        <h1>${headline}</h1>
        <form id="form" name="CreateCustomerForm" action="CreateCustomerServlet">
            Bezeichnung: <input id="bez" type="text" name="bezeichnung" value="${customer.getBezeichnung()}" /><br>
            Adresse: <input type="text" name="adresse" value="${customer.getAdresse()}" /><br>
            PLZ: <input id="plz" type="text" name="plz" value="${customer.getPlz()}" /><br>
            Ort: <input type="text" name="ort" value="${customer.getOrt()}" /><br>
            Vorname: <input type="text" name="vorname" value="${customer.getVorname()}" /><br>
            Nachname: <input type="text" name="nachname" value="${customer.getNachname()}" /><br>
            Telefon: <input type="text" name="telefonnummer" value="${customer.getTelefonnummer()}" /><br>
            Bemerkung: <input type="text" name="bemerkung" value="${customer.getBemerkung()}" /><br>
            <input type="button" value="Fertig" name="submitButton" onclick="check()"/>
        </form>
    </body>
</html>
