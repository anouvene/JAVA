<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion ecurie</title>
<link rel="icon" href="#">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="source.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Ecurie</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Accueil
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="ecurieCreate.jsp">Créer une écurie</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<!-- CREATION ECURIE/PILOTES -->
		<form id="ecurieForme">
			<h3>Ecurie</h3>
			<hr>
			<div class="form-group">
				<label for="txtNomEcurie">Nom écurie</label> <input type="text"
					class="form-control" id="txtNomEcurie">
			</div>
			<div class="form-group">
				<label for="txtNationnalite">Nationnalité</label> <input type="text"
					class="form-control" id="txtNationnalite">
			</div>

			<h3>Pilote</h3>
			<hr>
			<div class="form-inline">
				<div class="form-group mb-2">
					<label for="txtNomPilote">Nom pilote </label> <input type="text"
						class="form-control" id="txtNomPilote">
				</div>
				<div class="form-group mx-sm-3 mb-2">
					<label for="txtPrenomPilote">Prenom Pilote </label> <input
						type="text" class="form-control" id="txtPrenomPilote">
				</div>
				<button type="button" class="btn btn-primary mb-2"
					id="btnAjouterPilote">Ajouter un pilote</button>
			</div>

			<h3>Liste des pilotes</h3>
			<hr>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Nom</th>
						<th scope="col">Prenom</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody id="tbodyPilotes"></tbody>
			</table>

			<div class="form-group">
				<input type="submit" class="form-control" id="btnAjouterEcurie"
					value="Ajouter cet écurie">
			</div>
		</form>

		<!-- LISTE DES ECURIES -->
		<h3>Liste des écuries</h3>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">NOM</th>
				</tr>
			</thead>
			<tbody id="tbodyEcuries">
				<tr>
					<th scope="row" colspan="3">En cours ...</th>
				</tr>				
			</tbody>
		</table>
	</div>

</body>
</html>