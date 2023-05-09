<%-- 
    Document   : vista
    Created on : 07-may-2023, 18:13:51
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mastermind</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/CSS/style.css"/>

    </head>
    <body>
        <h1>Mastermind</h1>
        <br>
        <h4>Haz un intento</h4>
       <!-- <p>(Borrar ${numeroAleatorio})</p>-->
        <form action="ControladorJuego" method="POST">
            <div class="filaInputsCentrada">
                <c:forEach var="i" begin="1" end="${cifraIntrod}">
                    <div class="filaInputs">
                        <input type="number" name="campo${i}" min="0" max="9" value="1" class="centrarInput" required/><br>
                    </div>
                </c:forEach>
            </div>
            <br>
            <input type="submit" value="Intentar">
        </form>
        <br>

        <table border="2">
            <tr>
                <th>Intento</th>
                <th>Muertos</th>
                <th>Heridos</th>
            </tr>
            <c:forEach var="intento" items="${intentos}">
                <tr>
                    <td>${intento.numIntroducido}</td>
                    <td>${intento.muertos}</td>
                    <td>${intento.heridos}</td>
                </tr>
            </c:forEach>
        </table>

        <br>
        ${resultado}
        <br><br>      
        <form action="VolverPrincipio" method="POST">
            <input type="submit" value="Cancelar juego">
        </form>
    </body>
</html>
