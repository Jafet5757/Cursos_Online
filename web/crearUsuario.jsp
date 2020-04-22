<%-- 
    Document   : crearUsuario
    Created on : 17/04/2020, 08:09:45 PM
    Author     : EMPEÑO FACIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Crear cuenta</title>
	<link rel="stylesheet" type="text/css" href="css/estilo-crearCuenta.css">
</head>
<body>
        <%
            String name=request.getParameter("nombre");
            String app=request.getParameter("apellidop");
            String apm=request.getParameter("apellidom");
            String curp=request.getParameter("curp");
            String nac=request.getParameter("nacimiento");
            String dir=request.getParameter("direc");
            String cp=request.getParameter("cp");
            String tel=request.getParameter("tel");
            
        %>

	<form class="box" action="Controlador" method="post">
		<h1>
			Log-up
		</h1>
                <input type="hidden" name="instruccion" value="crearUsuario">
                <input type="hidden" name="name" value="<%=name%>">
                <input type="hidden" name="app" value="<%=app%>">
                <input type="hidden" name="apm" value="<%=apm%>">
                <input type="hidden" name="curp" value="<%=curp%>">
                <input type="hidden" name="nac" value="<%=nac%>">
                <input type="hidden" name="dir" value="<%=dir%>">
                <input type="hidden" name="cp" value="<%=cp%>">
                <input type="hidden" name="tel" value="<%=tel%>">
                
		<input type="text" name="usuario" placeholder="Username">
		<input type="password" name="password1" placeholder="Contraseña">
		<input type="password" name="password2" placeholder="Confirme contraseña">
		<input type="submit" value="Registrar">
	</form>
    
</body>
</html>
