<%-- 
    Document   : Home
    Created on : 18/04/2020, 06:10:15 PM
    Author     : EMPEÑO FACIL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DeepTure.com.*"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<script src="https://kit.fontawesome.com/a076d05399.js"></script>

	<link rel="stylesheet" type="text/css" href="css/estiloHome.css">
	<link rel="stylesheet" type="text/css" href="css/card.css">
	<link rel="stylesheet" type="text/css" href="css/position-cards.css">
	<link rel="stylesheet" type="text/css" href="css/search-box.css">
	<link rel="stylesheet" type="text/css" href="css/buttons-hover.css">
        <%
            //obtiene los datos del usuario
            List<Usuario> datos=(List<Usuario>) request.getAttribute("datosDelUsuario");
            //out.println(datos.get(0).getNombre());
            
            //creamos la cookie
            Cookie laCookie=new Cookie("Usuario",datos.get(0).getUser());
            //vida de la cookie
            laCookie.setMaxAge(24*60*60);
            // enviar a usuario
            response.addCookie(laCookie);
            Cookie pass=new Cookie("password",datos.get(0).getPassword());
            pass.setMaxAge(24*60*60);
            response.addCookie(pass);
        %>
<body>
    <script>
        function disponibilidad(){
            alert("No disponible");
        }
    </script>
	<nav>
		<input type="checkbox" name="" id="check">
		<label for="check">
			<i class="fas fa-bars" id="btn"></i>
			<i class="fas fa-times" id="cancel"></i>
		</label>
		<div class="sidebar">
                    <header style="font-family: Arial;"><%=datos.get(0).getNombre()%></header>
			<ul>
				<li><a href="Controlador" style="font-family: Arial;"><i class="fas fa-sliders-h"></i>Setting</a></li>
				<li><a href="#" style="font-family: Arial;"><i class="fas fa-link"></i>Shortcuts</a></li>
				<li><a href="#" style="font-family: Arial;"><i class="fas fa-stream"></i>Overview</a></li>
				<li><a href="#" style="font-family: Arial;"><i class="fas fa-calendar-week"></i>Events</a></li>
				<li><a href="#" style="font-family: Arial;"><i class="fas fa-question-circle"></i>about</a></li>
				<li><a href="index.html" style="font-family: Arial;"><i class="fas fa-sign-out-alt"></i>Exit</a></li>
				<li><a href="#" style="font-family: Arial;"><i class="fas fa-envelope"></i>Contact</a></li>
			</ul>
		</div>
	</nav>

	<section class="cursos">
		<div class="card mx-auto Fitness-Card" id="cards" onclick="disponibilidad()">
				<div class="card-body">
					<div clas="row center">
						<div class="col-6">
							<img src='https://firebasestorage.googleapis.com/v0/b/tutoriales-e4830.appspot.com/o/exercise.png?alt=media&token=b9c4b236-16a9-4a56-bba2-90c9660a0f06'/>
						</div>
						<div class="col-6 Fitness-Card-Info" id="txt">
							<h1>Ejercitate en casa</h1>
							<p>Ejercitate en casa durante la cuarentena</p>
						</div>
					</div>
				</div>
			</div>

			<div class="card mx-auto Fitness-Card" id="cards" onclick="disponibilidad()">
				<div class="card-body">
					<div clas="row center">
						<div class="col-6">
							<img src='https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Badge_js-strict.svg/739px-Badge_js-strict.svg.png'/>
						</div>
						<div class="col-6 Fitness-Card-Info" id="txt">
							<h1>Curso de JS</h1>
							<p>Curso de 10 videos</p>
						</div>
					</div>
				</div>
			</div>

			<div class="card mx-auto Fitness-Card" id="cards" onclick="disponibilidad()">
				<div class="card-body">
					<div clas="row center">
						<div class="col-6">
							<img src='img/computer.png'/>
						</div>
						<div class="col-6 Fitness-Card-Info" id="txt">
							<h1>Cyber seguridad</h1>
							<p>Proximamente</p>
						</div>
					</div>
				</div>
			</div>
	</section>

		

	<section class="agregar-buscar">
		<div class="search-box search">
			<input class="search-txt" type="text" name="" placeholder="Search course">
				<a class="search-btn" href="#">
					<i class="fas fa-search"></i>
				</a>
		</div>
		<header class="container">
		      <button class="btn btn2">Borrar curso</button>
		      <button class="btn btn3">Agregar nuevo curso</button>
		 </header>
	</section>	
        

</body>
</html>
