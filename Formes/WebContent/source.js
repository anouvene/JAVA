
function createForme(forme, rayon, cote, longueur, largeur, txtAction) {
	console.log(forme);
	$.ajax({
		url : "forme",
		type : "post",
		ContentType : "json",
		dataType : "json",
		data : {
			action: txtAction,
			f: JSON.stringify(forme),
			r: rayon,
			c: cote,
			lo: longueur,
			la: largeur
		},
		success: function(formes, status) {
			// alert(status);
			// Recuperer le resultat et appeler une fonction qui génere le
			// tableau
			genererTableForme(formes);
		}
	});
}

function affichageFormes() {

	$.ajax({
		url: "forme?action=READ_FORMES",
		type: "GET",
		dataType: "json",
		success: function(formes,status) {
			genererTableForme(formes);
		}
	})
}

function genererTableForme(formes) {
	let formesTR = "";
	for(let forme of formes){
		let tr = "<tr>"
					+ "<td>"+ forme.id_forme + "</td>"
					+ "<td>"+ forme.nom_forme + "</td>"
					+ "<td>"+ forme.x + "</td>" 
					+ "<td>"+ forme.y + "</td>"
					+ "<td>"; 
					if(forme.rayon != null && forme.rayon != "") {
						tr += forme.rayon;
					} else {
						tr += "";
					}		
					tr += "</td>"
					+ "<td>";
					if(forme.largeur != null) {
						tr += forme.largeur;
					} else {
						tr += "";
					}			
					tr += "</td>"
					+ "<td>";
					if(forme.longueur != null) {
						tr += forme.longueur;
					} else {
						tr += "";
					}	
					tr += "</td>"
					+ "<td>";
					if(forme.cote != null) {
						tr += forme.cote;
					} else {
						tr += "";
					}	
					tr += "</td>"
					+ "<td>"+ forme.surface +"</td>"
					+ "<td>"+ forme.perimetre +"</td>"
					  
					+ "<td colspan='2'><button class='btn btn-primary btn-dessiner' data-idForme='"+ forme.id_forme +"' data-toggle='collapse' data-target='#collapseCanvas'>Dessiner</button></td>"

				+ "</tr>";
					
			formesTR += tr;
		}
	
	$("#formesBody").html(formesTR);
}

// Dessiner un rectangle ou carre
function dessinerRectangle(forme) {
	var canvas = document.getElementById('canvas');
	  
	if (canvas.getContext) {
		let context = canvas.getContext('2d');
	
		// Position centree du carre ou rectangle  dans le canvas
		// let xcanvas = canvas.width / 2;
		// let ycanvas = canvas.height / 2;
		
		// Forme attributs: longueur et largeur
		let lo = "";
		let la = "";
		
		// Position dans le canvas
		let x = forme.x;
		let y = forme.y;
		
		// Nom de la forme
		let nomForme = forme.nom_forme;
		
		// Effacer la forme dans le canvas
		context.clearRect(0,0, canvas.width, canvas.height);
		
		if(nomForme.toLowerCase() == "carre") { // Carre
			// Dimension de la forme
			lo = forme.cote;
			la = forme.cote;		
		} else { // Rectangle
			lo = forme.longueur;
			la = forme.largeur;
		}
		
		// Definir dynamiquement la largeur et hauteur du canvas en fonction de la dimension de la forme 
		// et centrer cette derniere dans la canvas
		canvas.width = lo + 2*x;
		canvas.height = la + 2*y;
		
		// Dessiner et remplir la forme
		context.fillRect(x, y, lo, la);
	}
	
}

// Dessiner un cercle
function dessinerCercle(forme) {
	var canvas = document.getElementById('canvas');
	
	// Position centree de cercle dans le canvas
	// let xcanvas = canvas.width / 2;
	// let ycanvas = canvas.height / 2;
	
	// Position du cercle dans le canvas
	let x = forme.x;
	let y = forme.y;
	let r = forme.rayon;
	  
  if (canvas.getContext) {
    let context = canvas.getContext('2d');
    
    // Effacer la forme dans le canvas
    context.clearRect(0,0, canvas.width, canvas.height);
    
    // Definir dynamiquement la largeur et hauteur du canvas en fonction de la dimension de la forme 
	// et de x et y 
	let canvasW = canvas.width = 2*r + x;
	let canvasH = canvas.height = 2*r + y;
	
	// Dessiner le Cercle et le centrer dans la canvas
	context.beginPath();
    context.arc(canvasW/2, canvasH/2, r, 0, Math.PI * 2, true);  // Cercle : x, y, 0 => inclinaison de depart, true => sens inverse des aiguilles d'une montre
    context.fill();
    context.stroke();

  }
}

$(document).ready(function() {
		
	
	$("#autredonnee .form-group").not("#autredonnee .form-group:eq(0)").hide();
	
	// Event boutons radio + affichage champ de saisie corespondante
	$("#formeModal").on("click", ".form-check", function() {
		$("#autredonnee .form-group").hide();
		
		$(".form-check").on("click", function(){
			$("#formeChoix").find("input[type=text]").val("");
		});

		if($("#chkCercle").is(":checked")) { // Cercle
			$("#autredonnee .form-group:eq(0)").show();	
		} else if($("#chkCarre").is(":checked")) { // Carre
			$("#autredonnee .form-group:eq(3)").show();
		} else if($("#chkRectangle").is(":checked")) { // Rectangle
			$("#autredonnee .form-group:eq(1)").show();
			$("#autredonnee .form-group:eq(2)").show();
		}

	});
	
	$("#btnAjouter").on("click", function() {
		// Récupérer les valeurs saisies de la forme selectionnée
		let txtX = $("#txtX").val().trim();
		let txtY = $("#txtY").val().trim();
		let txtRayon = $("#txtRayon").val().trim();
		let txtLongueur = $("#txtLongueur").val().trim();
		let txtLargeur = $("#txtLargeur").val().trim();
		let txtCote = $("#txtCote").val().trim();
		
		if($("#chkCercle").is(":checked")) { // Cercle
			if(txtX !== "" && txtY !== "" && txtRayon !== "") {
				let forme = {				
					nom_forme: "Cercle",
					x : txtX,
					y : txtY,			
				};
				
				// Appel servlet via l'ajax
				createForme(forme, txtRayon, "", "", "",  "CREATE_CERCLE");
			}
		} else if($("#chkCarre").is(":checked")) { // Carre
			if(txtX !== "" && txtY !== "" && txtCote !== "") {
				$(".form-group").hide();
				$(".form-group:eq(1)").show();
				
				let forme = {
					 nom_forme: "Carre",
					 x : txtX,
					 y : txtY		
				};
				
				
				
				// Appel servlet via l'ajax
				createForme(forme, "", txtCote, "", "", "CREATE_CARRE");
			}			
		} else if($("#chkRectangle").is(":checked")) { // Rectangle
			if(txtX !== "" && txtY !== "" && txtLongueur !== "" && txtLargeur !== "") {
				let forme = {
					 nom_forme: "Rectangle",
					 x : txtX,
					 y : txtY		
				};
				
				// Appel servlet via l'ajax
				createForme(forme, "", "", txtLongueur, txtLargeur, "CREATE_RECTANGLE");
			}
		}
		
		// Fermer le Modal
		$("#formeModal").modal("hide");
	});
	
	// Modal fermé, rafraichir liste de formes
	$("#formeModal").on('hidden.bs.modal', function (e){
		affichageFormes();	
	});
	
	// Dessiner des formes avec canevas	
	$("#formesBody").on("click",".btn-dessiner",function(){
		let id_forme = $(this).attr("data-idforme");
		// trouver le contenu de td contenant le nom de la forme
		let nom_forme = $(this).closest("tr").find("td:eq(1)").text();
		
		$.ajax({			
			url: "forme?action=DESSINER&idForme=" + id_forme + "&nomForme=" + nom_forme,
			type: "Get",
			dataType: "json",
			success: function(forme,status){
				let nomforme = forme.nom_forme;
				switch (nomforme.toLowerCase()) {   // équivalent à forme["nom_forme"]
					case "cercle":						
						dessinerCercle(forme);
						break;
					default:											
						dessinerRectangle(forme);
				} 
			}
		});
	});
	
}); // Fin Ready






