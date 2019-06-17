let tblPilotes = [];

let tblEcuries = [];


function genererEcuries(tblEcuries) {
	let tr = "";
	for(let ecurie of tblEcuries) {
		tr += "<tr>"
			+"<th scope='row'>" + ecurie.id_ecurie + "</th>"
			+"<td>" + ecurie.nom + "</td>"
		+"</tr>";
	}
	
	$("#tbodyEcuries").html(tr);
	
}
$(function(){
	// Lancer l'affichage des ecuries
	
	$.ajax({
		url: "ecurie",
		type: "GET",
		ContentType: "application/json",
		dataType: "JSON",
		success: function(ecuries, status) {
			console.log(ecuries);
			// Liste des ecuries
			tblEcuries = ecuries;
			genererEcuries(tblEcuries);
		}			
	});
	
	
	// Ajouter un pilote
	$("#btnAjouterPilote").on("click", function() {
		let pilote = {};
		pilote.nom = $("#txtNomPilote").val().trim();
		pilote.prenom = $("#txtPrenomPilote").val().trim();
		tblPilotes.push(pilote);
		
		let trPilote = ""
		+"<tr>"
			+ "<td>" + pilote.nom + "</td>"
			+ "<td>" + pilote.prenom + "</td>"
			+ "<td><a href='#' title='Supprimer ce pilote' class='btn btn_danger'>Supprimer</a></td>"
		+ "</tr>";
		
		$("#tbodyPilotes").append(trPilote);
		
		// vider les champs de saisie
		$("#txtNomPilote").val("");
		$("#txtPrenomPilote").val("");
		
		
	});
	
	// Supprimer une ligne de pilote
	$("#tbodyPilotes").on("click", ".btn_danger", function() {
		$(this).closest("tr").remove();
	});
	
	// Ajouter une écurie	
	$("#ecurieForme").on("click", "#btnAjouterEcurie", function() {
		
		let ecurie = {
			nationnalite: $("#txtNationnalite").val().trim(),
			nom: $("#txtNomEcurie").val().trim(),
			pilotes: tblPilotes
		};
		
		$.ajax({
			url: "ecurie",
			type: "POST",
			ContentType: "application/json",
			dataType: "JSON",
			data: {ecurie: JSON.stringify(ecurie)},
			success: function(ecuries, status) {
				// alert(status);
				console.log(ecuries);
				// Liste des ecuries
				tblEcuries = ecuries;
				genererEcuries(tblEcuries);
			}			
		});

	});
	
	
	
	
	
	
	
	
});