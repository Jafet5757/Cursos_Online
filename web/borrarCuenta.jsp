<%-- 
    Document   : borrarCuenta
    Created on : 19/04/2020, 05:14:15 PM
    Author     : EMPEÑO FACIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="Controlador">
            <table>
                <tr>
                    <td><input type="hidden" name="instruccion" value="borraCuenta"></td>
                </tr>
                <tr>
                    <td>Ingrese su nombre de usuario</td>
                    <td><input type="text" name="user"></td>
                </tr>
                <tr>
                    <td>Ingrese su contraseña</td>
                    <td><input type="password" name="pass"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
