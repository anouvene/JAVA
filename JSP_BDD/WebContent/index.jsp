<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="adelium.cours.java.Genre"%>
<%@page import="adelium.cours.java.IDAO"%>
<%@page import="adelium.cours.java.DAO_Societe"%>
<%@page import="adelium.cours.java.Societe"%>
<%@page import="adelium.cours.java.Personne"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>IMC Traitement</title>
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous">
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
			
		<link rel="stylesheet" href="./style.css">

	</head>
	<body>
	
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
					<li class="nav-item active"><a class="nav-link" href="#">Home</a>
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
					<h1>Calculer votre indice de masse corporelle (IMC)</h1>
				</div>
			</div>
			<form action="./resultats.jsp" method="GET" class="row">
	
				<div class="col-md-6 offset-md-2">
					
					<div class="form">
						<div class="row">
							<!--Id Personne-->
							<div class="col-sm-4">
								<div class="form-group">
									<label for="idPersonneTxt">Id Personne:</label> 
									<input type="text" name="idPersonneTxt" class="form-control">
								</div>
							</div>
							
							<!--Nom-->
							<div class="col-sm-4">
								<div class="form-group">
									<label for="nomtxt">Nom:</label> <input type="text"
										name="nomTxt" class="form-control">
								</div>
							</div>
							
							<!--Prenom-->
							<div class="col-sm-4">
								<div class="form-group">
									<label for="prenomTxt">Prenom:</label> 
									<input type="text" name="prenomTxt" class="form-control">
								</div>
							</div>
						</div>
	
						<!--Poids-->
						<div class="form-group">
							<label for="poidsTxt">Poids:</label> 
							<input type="number" name="poidsTxt" class="form-control" placeholder="Poids en kg">
						</div>
	
						<!--Taille-->
						<div class="form-group">
							<label for="tailleTxt">Taille:</label> <input type="number"
								name="tailleTxt" min="1.0" max="2.36" step="0.01"
								class="form-control" id="tailleTxt"
								placeholder="Taille en m, exemple: 1.70">
						</div>
	
						<!--Genre-->
						<div class="form-group">
							<label for="lstGenreTxt">Genre:</label> 
							<select name="lstGenreTxt" class="form-control">
								<% 
									for(Genre sexe: Genre.values()) {
								%>
									<option value="<%= sexe.name().toLowerCase() %>"><%= sexe.name() %></option>
								<%
									}
								%>								
							</select>
						</div>
						
						<!--Id Societe-->					
						<div class="form-group">
							<label for="idSocieteTxt">Id Sociéte :</label> 
							<input type="text" name="idSocieteTxt" class="form-control">
						</div>
						
	
						<div class="form-group">
							<input type="submit" class="btn btn-info btn-block" value="Valider">
						</div>
					
					</div>
					
				</div>
				
				<div class="col-md-4">
					<h3>Votre choix</h3>
					<div class="form-check">
					  <input id="imcLab" class="form-check-input" type="checkbox" name="imcCheck">
					  <label class="form-check-label" for="imcLab">
					    IMC
					  </label>
					</div>
					
					<div class="form-check">
					  <input id="poidsMinLab" class="form-check-input" type="checkbox" name="poidsMinCheck">
					  <label class="form-check-label" for="poidsMinLab">
					    Poids mini
					  </label>
					</div>
					
					<div class="form-check">
					  <input id="poidsMax" class="form-check-input" type="checkbox" name="poidsMaxCheck">
					  <label class="form-check-label" for="poidsMax">
					    Poids maxi
					  </label>
					</div>
					
					<div class="form-check">
					  <input id="poidsIdealLab" class="form-check-input" type="checkbox" name="poidsIdealCheck">
					  <label class="form-check-label" for="poidsIdealLab">
					    Poids ideal
					  </label>
					</div>
					
					<div class="form-check">
					  <input id="diagLab" class="form-check-input" type="checkbox" name="diagCheck">
					  <label class="form-check-label" for="diagLab">
					    Diagnostic
					  </label>
					</div>
					
					
				</div>
			</form>
		
			<!-- SOCIETES -->
			<div class="row">
				<!-- Liste des societes -->
				<form id="societe_form" class="col-md-6 offset-md-2">
					<h3>SOCIETES</h3>
					<table class="table table-condensed" style="border-collapse: collapse;">
						<thead>
							<tr>
								<th>#</th>
								<th>Nom</th>
								<th>CA</th>
								<th>Activite</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody id="societesTbody">					
							<!--  Partie dynamique societes -->
							
							<%
								IDAO<Societe> daoSociete = new DAO_Societe();
								List<Societe> societes = daoSociete.RetreiveAll();
								
								for(Societe societe : societes) {
									String tr = "<tr>"
											+ "<td>" + societe.get_ID_Societe() + "</td>"
											+ "<td>" + societe.get_Nom() + "</td>"
											+ "<td>" + societe.get_CA() + "</td>"
											+ "<td>" + societe.get_Activite() + "</td>"
											+ "<td class='actions'>"
											+ "<a href='#collapsePersonnes' title='Voir les personnes' class='btn btn-primary btn-voir' data-idsociete='" + societe.get_ID_Societe() + "'" 
											+ "data-toggle='collapse' data-target='#collapsePersonnes'><i class='material-icons md-24'>visibility</i></a> "	
											+ "<a href='#societe' title='Modifier une societe' class='btn btn-warning btn-edit'"	
											+ "data-toggle='modal' data-target='#editSocieteModal'><i class='material-icons md-24'>edit</i></a> "	  
											+ "<a href='#societe' title='Supprimer une societe' class='btn btn-danger btn-delete' data-idsociete='" + societe.get_ID_Societe() + "'><i class='material-icons md-24'>delete_forever</i></a>"									
											+ "</td>"
											+ "</tr>";	
											
								    out.print(tr);
								}							
							%>
	
						</tbody>
					</table>
				</form>
			
			</div>
			
			
			<!-- EMPLOYES DE LA SOCIETE -->
			<div id="collapsePersonnes" class="row collapse">
				<div class="col-md-6 offset-md-2">				
					<h3 class="col-">EMPLOYES</h3>
					<table class="table table-condensed table-responsive-sm" style="border-collapse: collapse;">
						<thead>
							<tr>
								<th scope="col">Identifiant personne</th>
								<th scope="col">Identifiant societe</th>						
								<th scope="col">Nom</th>
								<th scope="col">Prenom</th>
								<th scope="col">Poids</th>
								<th scope="col">Taille</th>
								<th scope="col">Sexe</th>
							</tr>
						</thead>
						<tbody id="personnesTbody">
							<!-- Partie dynamique employes -->
							
						</tbody>
					</table>
				</div>
			</div>
		
		
		
		
		
		</div>
	
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		
		<script src="./js/source.js"></script>
	</body>
</html>