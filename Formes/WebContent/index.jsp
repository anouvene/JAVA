<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="favicon.ico">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="source.js"></script>




<title>LISTE DES FORMES GEOMETRIQUES</title>
</head>
<body data-spy="scroll" data-target="#collapseCanvas">


	<div class="container">
		<h1>Liste des formes</h1>
		<table class="table table-responsive-sm table-dark">
			<thead>
				<tr>
					<th scope="col">IDForme</th>
					<th scope="col">Nom Forme</th>
					<th scope="col">X</th>
					<th scope="col">Y</th>
					<th scope="col">Rayon</th>
					<th scope="col">Largeur</th>
					<th scope="col">Longueur</th>
					<th scope="col">Cote</th>
					<th scope="col">Surface</th>
					<th scope="col">Perimetre</th>
					<th scope="col">Actions</th>

				</tr>
			</thead>
			<tbody id="formesBody">
				<!-- générer dynamiquement dans source js -->

			</tbody>
		</table>
		
		<!-- Button trigger modal -->
		<button class="btn btn-success" id="btn-forme" data-toggle="modal"
			data-target="#formeModal">Nouvelle Forme</button>

		<!-- CANVAS -->
		<div id="collapseCanvas" class="collapse">
			<canvas id="canvas" width="500" height="250"></canvas>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="formeModal">
			<div class="modal-dialog modal-dialog-centered modal-xl">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Saisie des
							données des formes</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form id="formeChoix">
							<div class="row">
								<!-- Boutons choix formes -->
								<div class="col-sm-3 offset-sm-1">
									<div class="form-check">
										<input class="form-check-input" type="radio" name="btnCheck" id="chkCercle"
											checked> <label class="form-check-label"
											for="chkCercle"> Cercle</label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="btnCheck" id="chkCarre">
										<label class="form-check-label" for="chkCarre"> Carre</label>
									</div>
									<div class="form-check disabled">
										<input class="form-check-input" type="radio" name="btnCheck" id="chkRectangle">
										<label class="form-check-label" for="chkRectangle">
											Rectangle</label>
									</div>
								</div>

								<!-- Donnees formes -->
								<div class="col-sm-7">
									<div class="row" id="xy">
										<div class="form-group mb-2">
											<label for="txtX" class="sr-only">X</label> <input
												type="text" class="form-control" id="txtX" placeholder="X">
										</div>
										<div class="form-group mx-sm-3 mb-2">
											<label for="txtY" class="sr-only">Y</label> <input
												type="text" class="form-control" id="txtY" placeholder="Y">
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12 autredonnee" id="autredonnee">
											<!-- Pour le rayon du cercle -->
											<div class="form-group">
												<label for="txtRayon">Rayon</label> 
												<input type="text" class="form-control" id="txtRayon" placeholder="Rayon (cm)">
											</div>

											<!-- Pour la longeur du rectangle -->
											<div class="form-group">
												<label for="txtLongueur">Longueur</label>
												<input type="text" class="form-control" id="txtLongueur" placeholder="Longeur (cm)">
											</div>

											<!-- Pour la largeur du rectangle -->
											<div class="form-group">
												<label for="txtLargeur">Largeur</label> 
												<input type="text" class="form-control" id="txtLargeur" placeholder="Largeur (cm)">
											</div>

											<!-- Pour le cote du carre -->
											<div class="form-group">
												<label for="txtCote">Cote</label> 
												<input type="text" class="form-control" id="txtCote" placeholder="Cote (cm)">
											</div>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Fermer</button>
						<button type="button" class="btn btn-primary" id="btnAjouter">Ajouter</button>
					</div>
				</div>
			</div>
		</div>





	</div>
	
	<script>
	
		$(document).ready(function() {
			affichageFormes();
			
			// dessinerRectangle();
			// dessinerCercle();

			/* $('body').scrollspy({
				target : '#collapseCanvas'
			}) */
		})
	</script>

</body>
</html>