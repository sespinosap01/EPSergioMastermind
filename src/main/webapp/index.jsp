<%-- 
    Document   : index
    Created on : 07-may-2023, 18:50:49
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mastermind</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/CSS/style.css"/>
    </head>
    <body>
        <h1>Mastermind</h1>
        <p>Mastermind, juego de los muertos y heridos
            Inicialmente el usuario debe introducir la cantidad de
            dígitos con los que conformar el número estando esta en un 
            rango de 2 a 9 dígitos. A partir de ahora llamaremos X a 
            esa cantidad de dígitos.Básicamente el juego consiste en deducir el 
            número de X dígitos, entre 0 y 9, no repetidos, generados aleatoriamente 
            por el programa, teniendo en cuentas las “pistas” que proporciona el 
            juego. El jugador irá escribiendo en cada intento un número de X dígitos. 
            Por cada dígito que esté en el número generado por el programa, pero no esté 
            en su posición correcta, se contará como “herido“.
            Por cada dígito que esté en el número generado por el programa, y esté en su 
            posición correcta, se contará como “muerto“.
            Por ejemplo, si el número generado por el programa es el 7564 y en la intento 
            se introduce el 1574 la respuesta debería ser de 2 muertos ( por el 5 y el 4) y 
            1 herido (por el 7). El juego finalizará cuando el resultado sea de X muertos, es 
            decir, cuando el jugador deduzca el número. En ese caso se indicará el número de 
            intentos que ha realizado. 
        </p>
        <br>
        <br>
        <h3>Introduce un numero entre el 2 y el 9 para comenzar el juego</h3>
        <br>
        <form action="FrontController" method="POST">
            <input type="number" name="cifraIntrod" min="2" max="9" value="2" required>
            <input type="submit" name="Enviar" value="Comenzar">
        </form>
    </body>
</html>
