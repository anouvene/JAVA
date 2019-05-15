<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="adelium.cours.java.Personne"%>
<%@page import="adelium.cours.java.Genre"%>
<%@page import="adelium.cours.java.IDAO"%>
<%@page import="adelium.cours.java.DAO_Personne"%>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>IMC Traitement</title>
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous">
		<link rel="stylesheet" href="./style.css">
	</head>
	<body>
		<%
			String idPersonne = request.getParameter("idPersonneTxt").trim();
			String nom = request.getParameter("nomTxt").trim();
			String prenom = request.getParameter("prenomTxt").trim();
		    String poids = request.getParameter("poidsTxt").trim();
		    String taille = request.getParameter("tailleTxt").trim();
		    String sexe = request.getParameter("lstGenreTxt").trim();
		    
		    String idSociete = request.getParameter("idSocieteTxt");
		    
		    Personne p1 = null;
		    
		    if ( (idPersonne != null && !idPersonne.equals("")) 
		    		&& (nom != null && !nom.equals("")) 
		    		&& (prenom != null && !prenom.equals("")) 
		    		&& (poids != null && !poids.equals("")) 
		    		&& (taille != null && !taille.equals("")) 
		    		&& (sexe != null  && !sexe.equals("")) ) {
		    	// int _ID_Personne, String _Nom, String _Prenom, float _Poids, float _Taille, Genre _Sexe
		    	p1 = new Personne( 
		    			Integer.valueOf(idPersonne), 
		    			nom, 
		    			prenom, 
		    			Float.valueOf(poids), 
		    			Float.valueOf(taille), 
		    			Genre.valueOf(sexe.toUpperCase()),
		    			Integer.valueOf(idSociete)
		    		);
		    	
		    	// Créer Personne dans la BDD
		    	IDAO<Personne> daoPersonne = new DAO_Personne();
		    	daoPersonne.Create(p1);
		    	
		    	
		    }
		    
		    String imcChecked = request.getParameter("imcCheck"); // on ou off
		    String poidsMinChecked = request.getParameter("poidsMinCheck");
		    String poidsMaxChecked = request.getParameter("poidsMaxCheck");
		    String poidsIdealChecked = request.getParameter("poidsIdealCheck");
		    String diagChecked = request.getParameter("diagCheck");		    

		%>
	
		<!-- Navbar -->
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<!-- Toggler/collapsibe Button -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- Nav links -->
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="./index.jsp">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
			</div>
		</nav>
	
		<div class="container-fluid">
			<div class="row">
				<div class="col text-center">
					<h1>Résultats de <%= p1 != null ? p1.get_Nom() + " " + p1.get_Prenom() : "" %></h1>
				</div>
			</div>
			
	
			<div class="col-md-8 offset-md-2">
				
				<div class="form">
					<!--IMC-->
					<div class="form-group">
						<label for="imcTxt">IMC:</label> 
						<input type="text" name="imcTxt" class="form-control" 
							   value="<% if(imcChecked != null && p1 != null) {
									out.print(p1.IMC());
								}%>" 
						readonly>
					</div>

					<!--Poids min-->
 					<div class="form-group">
						<label for="poidsMinTxt">Poids min:</label> 
						<input type="text" name="poidsMinTxt" class="form-control" value="<%= poidsMinChecked != null && p1 != null  ? p1.PoidsMin() : "" %>" readonly>
					</div>
					
					<!--Poids max-->
 					<div class="form-group">
						<label for="poidsMaxTxt">Poids max:</label> 
						<input type="text" name="poidsMaxTxt" class="form-control" value="<%= poidsMaxChecked != null && p1 != null ? p1.PoidsMax() : "" %>" readonly>
					</div>
					
					<!--Poids idéal-->
 					<div class="form-group">
						<label for="poidsIdealTxt">Poids idéal:</label> 
						<input type="text" name="poidsIdealTxt" class="form-control" value="<%= poidsIdealChecked != null && p1 != null ?  p1.PoidsIdeal() : "" %>" readonly>
					</div>

					<!--Diagnostic-->
 					<div class="form-group">
						<label for="diagnosticTxt">Diagnostic:</label> 
						<input type="text" name="diagnosticTxt" class="form-control" value="<%= diagChecked != null && p1 != null  ? p1.afficherDiagnostic(): "" %>" readonly>
					</div>
				
				</div>
				
			</div>
			
		</div>
	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</body>
</html>