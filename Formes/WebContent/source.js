
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

function dessinerRectangle(forme) {
	var canvas = document.getElementById('canvas');
	let context = canvas.getContext('2d');
			
	  
	if (canvas.getContext) {
	    var ctx = canvas.getContext('2d');
	
	
		let xcanvas = canvas.width / 2;
		let ycanvas = canvas.height / 2;
		
		let nomForme = forme.nom_forme;
	
		let lo = forme.longueur;
		let la = forme.largeur;
		let x = forme.x + xcanvas;
		let y = forme.y + ycanvas;


		
		context.clearRect(0,0, canvas.width, canvas.height);
		canvas.width = canvas.width;
		
	    ctx.fillRect(x, y, lo, la);
	}
  
	
}

function dessinerCarre(forme) {
	var canvas = document.getElementById('canvas');
	let context = canvas.getContext('2d');
			
	  
	if (canvas.getContext) {
	    var ctx = canvas.getContext('2d');
	
	
		let xcanvas = canvas.width / 2;
		let ycanvas = canvas.height / 2;
		
		let nomForme = forme.nom_forme;

		let lo = forme.cote;
		let la = forme.cote;
		let x = forme.x + xcanvas;
		let y = forme.y + ycanvas;


		
		context.clearRect(0,0, canvas.width, canvas.height);
		canvas.width = canvas.width;
		
		
		context.rect(x, y, lo,la);
		context.fill();

	}
  
	
}



function dessinerCercle(forme) {
	var canvas = document.getElementById('canvas');
	let xcanvas = canvas.width / 2;
	let ycanvas = canvas.height / 2;

	let x = forme.x + xcanvas;
	let y = forme.y + ycanvas;
	let r = forme.rayon;
	
	let context = canvas.getContext('2d');

	
	context.clearRect(0,0, canvas.width, canvas.height);
	canvas.width = canvas.width;
	
	  
  if (canvas.getContext) {
    var ctx = canvas.getContext('2d');

    ctx.beginPath();
    ctx.arc(x, y, r, 0, Math.PI * 2, true);  // Cercle extérieur
    ctx.fill();
    ctx.stroke();

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
		// récupérer les valeurs saisies de la forme selectionnée
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
	
	// dessiner des formes avec canevas
	
	$("#formesBody").on("click",".btn-dessiner",function(){
		let id_forme = $(this).attr("data-idforme");
		// trouver le contenu de td contenant le nom de la forme
		let nom_forme = $(this).closest("tr").find("td:eq(1)").text();
		// alert(nom_forme);
		
		$.ajax({
			
			url: "forme?action=DESSINER&idForme=" + id_forme + "&nomForme=" + nom_forme,
			type: "Get",
			dataType: "json",
			success: function(forme,status){
				let nomforme = forme.nom_forme;
				switch (nomforme.toLowerCase()) {   // équivalent à
													// forme["nom_forme"]
					case "cercle":						
						dessinerCercle(forme);
					break;
					case "rectangle":											
						dessinerRectangle(forme);
					break;
					case "carre": 						
						dessinerCarre(forme);
					break;
				
				
				} 
			}
		
		
			
			
			
		})
		
		
		
	})
	
}); // Fin Ready






