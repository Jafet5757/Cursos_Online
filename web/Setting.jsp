<%-- 
    Document   : Setting
    Created on : 19/04/2020, 05:06:46 PM
    Author     : EMPEÑO FACIL
--%>

<%@page import="java.util.List"%>
<%@page import="DeepTure.com.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            //obtiene los productos del controlador
            List<Usuario> datos=(List<Usuario>) request.getAttribute("datosDelUsuario");
        %>
    </head>
    <body>
        <%
            boolean ex=Boolean.parseBoolean(String.valueOf(request.getAttribute("exito")));
        %>
        <c:if test="${ex}">
            <script>
                alert("Ha ocurrido un error")
            </script>
        </c:if>
        <form action="Controlador" method="post">
            <input type="hidden" value="actualizarDatos" name="instruccion">
            <table>
                <tr>
                    <td>Nombre del usuario</td>
                    <td><input type="text" name="name" placeholder="Primer nombre" value="<%=datos.get(0).getNombre()%>"></td>
                </tr>
                <tr>
                    <td>Apellido materno</td>
                    <td><input type="text" name="app" placeholder="Apellido paterno" value="<%=datos.get(0).getApellidoP()%>"></td>
                </tr>
                <tr>
                    <td>Apellido paterno</td>
                    <td><input type="text" name="apm" placeholder="Apellido materno" value="<%=datos.get(0).getApellidoM()%>"></td>
                </tr>
                <tr>
                    <td>CURP</td>
                    <td><input type="text" name="curp" placeholder="CURP" value="<%=datos.get(0).getCurp()%>"></td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><input type="text" name="nac" placeholder="Fecha de nacimiento" value="<%=datos.get(0).getFecha()%>"></td>
                </tr>
                <tr>
                    <td>Direccion</td>
                    <td><input type="text" name="dir" placeholder="Direccion" value="<%=datos.get(0).getDireccion()%>"></td>
                </tr>
                <tr>
                    <td>CP</td>
                    <td><input type="text" name="cp" placeholder="Codigo postal" value="<%=datos.get(0).getCp()%>"></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="tel" placeholder="Telefono" value="<%=datos.get(0).getTel()%>"></td>
                </tr>
                <tr>
                    <td>Nombre de usuario</td>
                    <td><input type="text" name="usuario" placeholder="Usuario" value="<%=datos.get(0).getUser()%>"></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" name="password" placeholder="Password" value="<%=datos.get(0).getPassword()%>"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Guardar actualizaciones"></td>
                </tr>
            </table>
        </form>
                
                
            <table> 
                <tr>
                    <td>
                        <form action="borrarCuenta.jsp" method="post">
                            <input type="submit" value="Borrar cuenta">
                        </form>
                    </td>

                    <td>
                        <form action="Controlador" method="post">
                            <input type="hidden" value="iniciarSesion" name="instruccion">
                            <input type="hidden" name="name" value="<%=datos.get(0).getUser()%>">
                            <input type="hidden" name="password" value="<%=datos.get(0).getPassword()%>">
                            <input type="submit" value="Ir al home">
                        </form>
                    </td>
                </tr>
            </table>
    </body>
</html>
