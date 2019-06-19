<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Cooande</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		<script src="./resources/source.js"></script>
	</head>
	<body>
	
		<div class="jumbotron text-center">
			<h1>M2I Service</h1>
			<p>A project by Tuan, Severine, Anis and Michael</p>
		</div>
	
		<div class="container">
			<h2>Saisie de commande</h2>
			<br></br>
			<div class="col-sm-4">
				<form action="commande" method="post">
					<div class="form-group">
						<label for="lstproduits">Intitule:</label> <select
							class="form-control" name="lstproduits" id="lstproduits">
							<option value="0">Choisir un produit</option>
							<%
								
							%>
						</select>
					</div>
					<div class="form-group">
						<label for="txtNbrJours">Nombre de jours:</label> <input
							type="text" class="form-control" id="idNbrJours" name="nbjours">
					</div>
					<div class="form-group">
						<label for="txtPJAT">Prix Journalier:</label> <input type="text"
							class="form-control" id="idPJAT" name="pjht">
					</div>
					<div class="form-group">
						<label for="txtRefClient">Référence client:</label> <input
							type="text" class="form-control" id="idRefClient"
							name="refclient">
					</div>
					<br></br>
					<div align="right">
						<button type="Submit" class="btn btn-primary">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>