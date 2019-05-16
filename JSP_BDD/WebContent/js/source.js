$(function() {
	// Génerer tableau eleves
	// GenererTableauEleves(tblEleves , $("#eleveTbody"));
	
	// Ajouter eleve
	$("#btnAddEleve").on("click", function() {

		const nomTxt = $("#txtNom").val().trim();
		const prenomTxt = $("#txtPrenom").val().trim();

		if(nomTxt !== "" && prenomTxt !== "") {
			// Nouvel eleve
			const eleve = {
				idEleve: tblEleves.length + 1,
				nom: nomTxt,
				prenom: prenomTxt,
				notes: []
			}

			// Ajouter eleve dans la table tblEleves
			tblEleves.push(eleve);
		}
		
		// Vider les champs
		$("#txtIdEleve").val("");
		$("#txtNom").val("");
		$("#txtPrenom").val("");
		
		// Fermer le formulaire d'edition
		$('#collapseEleveFormAjout').collapse('hide');

		// Reactualiser l affichage des eleves
		GenererTableauEleves(tblEleves , $("#eleveTbody"));
		
	});

	// Voir les personnes de la societe
	$("#societe_form").on("click", ".btn-voir", function() {
		$(".btn-voir").removeClass("btn-success");
		$(".btn-voir").find("i").empty().text("visibility");

		// Changer l'apparence du bouton
		if($(this).find("i").text() == "visibility") {
			
			$(this).addClass("btn-success");
			$(this).find("i").empty().text("visibility_off");
		} else {
			$(this).removeClass("btn-success");
			$(this).find("i").empty().text("visibility");

			$("#collapsePersonnes").collapse('hide');
		}

		// Generer les tr personnes via AJAX		
		$.ajax({
			url : "SocieteServlet",
			type : "GET",
			dataType : "html",
			data : "action=GET_ALL_PERSONNES&idSociete=" + $(this).attr("data-idsociete"),
			success : function(res, status) {
				$("#personnesTbody").html(res);
			}
		});
		


		// Reouvrir immediatement le bloc collapseNotes when il est fermé
		$('#collapsePersonnes').on('hidden.bs.collapse', function () {
			$(this).collapse("show");
		});
		
		
	});
		
	// Supprimer une societe
	$("#societe_form").on("click", ".btn-delete", function() {
		
		/*$.ajax({
			url : "SocieteServlet",
			type : "POST",
			dataType : "html",
			
//			data : {
//				"idSociete": $(this).attr("data-idsociete"),
//				"action": "DELETE_SOCIETE"
//			},
			
			data: "action=DELETE_SOCIETE" + "&idSociete=" + $(this).attr("data-idsociete"),
			success : function(res, status) {
				$("#societesTbody").empty().html(res);
			}
		
		
		});*/
		
		$.ajax({
			url : "SocieteServlet?idSociete=" + $(this).attr("data-idsociete"),
			type : "DELETE",
			dataType : "html",
			success : function(res, status) {
				$("#societesTbody").html(res);
			}
		});


		// Vider et fermer notesTbody
		$("#personnesTbody").empty();
		$("#collapsePersonnes").removeClass("show");
		
		
	});
			
	// MODAL: Societe et ses employes
	$("#societe_form").on("click", ".btn-edit", function() { // Delegate event click
		$this = $(this); // .btn-edit
		
		// Fermer collapse personnes
		$("#collapsePersonnes").collapse("hide");
				
		$('#editSocieteModal').on('shown.bs.modal', function (e) {
			$(this).css({"padding-right": "0px", "display" :" block"}); // enlever padding-right du modal
			
			$(this).find("#societesModalTbody").empty();
			
			$.ajax({
				url : "SocieteServlet",
				type : "GET",
				data: "action=READ_SOCIETE&idSociete=" + $this.attr("data-idsociete"),
				dataType : "html",
				success : function(res, status) {
					$("#societeModal").html(res);
				}
			});
		});
	});
	
	// MODAL: Ajouter une personne a la societe
	$("#btnModalAjoutPersonne").on("click", function() {
		$this = $(this); // .btn-edit

		// Societe en cours
		const idSociete = $this.parents(".modal-content").find("input[name=idSociete]").val();		
		const nbPersonnes = parseInt($("#societeModal").find("table").attr("data-nbpersonnes"), 10);
			
		// Générer une ligne de personne	
		$tr = $("<tr>"
				+ "<td>" + "<input type='text' name='idPersonne' value='" + (nbPersonnes + 1) + "' class='form-control' readonly>" + "</td>"
				+ "<td>" + "<input type='text' name='nom' class='form-control'>" + "</td>"
				+ "<td>" + "<input type='text' name='prenom' class='form-control'>"+ "</td>"
				+ "<td>" + "<input type=''text' name='poids' class='form-control'>" +"</td>"
				+ "<td>" + "<input type='text' name='taille' class='form-control'>" +"</td>"
				+ "<td>" + "<select name='sexe' class='form-control genre'><option value='MASCULIN'>MASCULIN</option><option value='FEMININ'>FEMININ</option></select>" +"</td>"
				+ "<td><a href='#' title='Modifier une personne' class='btn btn-success btn-warning btn-modal-add' data-idpersonne='" + idSociete +"'><i class='material-icons md-24'>border_color</i></a></td>"
				+ "<td><a href='#' title='Annuler' class='btn btn-secondary btn-modal-cancel'><i class='material-icons md-24'>cancel</i></a></td>"				
				+ "</tr>");
		
		$tr.appendTo($("#personnesModalTbody"));
		
		
		// Récuperer la saisie et inserer dans la base via ajax
		$(".btn-modal-add").find("i:contains('border_color')").on("click", function() {
			$this = $(this);
			// Change button appearance
			if($this.text() === "border_color" && $this.closest("a").hasClass("btn-warning")) {
				
				$this.empty().text("edit");
				$this.closest("a").removeClass("btn-warning");
				
				// Remove "readonly"
				$this.closest("tr").find("input[name=nom], input[name=prenom], input[name=poids], input[name=taille], input[name=sexe]").attr("readonly", "readonly");
				
				// Get inputs values
				const idPersonne = $(this).closest("tr").find("input[name=idPersonne]").val().trim();
				const nom = $(this).closest("tr").find("input[name=nom]").val().trim();
				const prenom = $(this).closest("tr").find("input[name=prenom]").val().trim();
				const poids = $(this).closest("tr").find("input[name=poids]").val().trim();
				const taille = $(this).closest("tr").find("input[name=taille]").val().trim();
				const sexe = $(this).closest("tr").find("select[name=sexe]").val().trim();
				
				// Insert
				if(idPersonne !== "" && nom !=="" && prenom !== "" && poids !== "" && taille !== "" && sexe !== "") {
					$.ajax({
						url: "SocieteServlet?action=CREATE_PERSONNE"
							+ "&idPersonne=" + idPersonne 
							+ "&nom=" + nom 
							+ "&prenom=" + prenom
							+ "&poids=" + poids
							+ "&taille=" + taille
							+ "&sexe=" + sexe
							+ "&idSociete=" + idSociete,
						type: "POST",
						dataType: "html",
						success: function(res, status) {
							alert(status);				
						}
					});
				}
				
			} else {
				// Changer apparence bouton
				$this.empty().text("border_color");
				$this.closest("a").addClass("btn-warning");
				
				// Add "readonly"
				$this.closest("tr").find("input[name=nom], input[name=prenom], input[name=poids], input[name=taille], input[name=sexe]").removeAttr("readonly");	
				
			}			
			
		});
		

		
	});	

	// MODAL: Annuler ajout note
	$("#societeModal").on("click", ".btn-modal-cancel", function() {
		$(this).closest("tr").remove();
	});
	
	// MODAL: Modifier une ligne de personne
	$("#editSocieteModal").on("click", ".btn-modal-edit", function() {
		
		if($(this).find("i").text() === "edit" && $(this).closest("a").hasClass("btn-success")) {
			// Change button appearance
			$(this).find("i").empty().text("border_color");
			$(this).closest("a").addClass("btn-warning");
			
			// Remove "readonly"
			$(this).closest("tr").find("input[name=nom], input[name=prenom], input[name=poids], input[name=taille], input[name=sexe]").removeAttr("readonly");
			
			
		} else {
			// Changer apparence bouton
			$(this).find("i").empty().text("edit");
			$(this).closest("a").removeClass("btn-warning");
			
			// Add "readonly"
			$(this).closest("tr").find("input[name=nom], input[name=prenom], input[name=poids], input[name=taille], input[name=sexe]").attr("readonly", "readonly");	
			
		}
		
		$(this).find("i:contains('border_color')").on("click", function() {
			// Get inputs values
			const idPersonne = $(this).closest("tr").find("input[name=idPersonne]").val().trim();
			const nom = $(this).closest("tr").find("input[name=nom]").val().trim();
			const prenom = $(this).closest("tr").find("input[name=prenom]").val().trim();
			const poids = $(this).closest("tr").find("input[name=poids]").val().trim();
			const taille = $(this).closest("tr").find("input[name=taille]").val().trim();
			const sexe = $(this).closest("tr").find("input[name=sexe]").val().trim();

			// Update
			$.ajax({
				url: "SocieteServlet?action=UPDATE_PERSONNE"
					+ "&idPersonne=" + idPersonne 
					+ "&nom=" + nom 
					+ "&prenom=" + prenom
					+ "&poids=" + poids
					+ "&taille=" + taille
					+ "&sexe=" + sexe,
				type: "PUT",
				dataType: "html",
				success: function(res, status) {
					// alert(status);
				}
			});
		});
	});

	// MODAL: Mettre a jours eleve et ses notes
	$('#btnModalMaj').on("click", function() {
		// Fermer le modal d'edition eleve
		$('#editSocieteModal').modal('hide');
		
		$('#editSocieteModal').on('hidden.bs.modal', function (e) {
			
			// Societe
			const idSocieteTxt = $(this).find("input[name=idSociete]").val().trim();
			const nomTxt = $(this).find("input[name=nomSocieteTxt]").val().trim();
			const caSocieteTxt = $(this).find("input[name=caSocieteTxt]").val().trim();
			const activiteSocieteTxt = $(this).find("input[name=activiteSocieteTxt]").val().trim();
			
			
			let societeToUpdate = "action=UPDATE_SOCIETE&idSociete=" + idSocieteTxt + "&nom=" + nomTxt + "&ca=" + caSocieteTxt + "&activite=" + activiteSocieteTxt;
			
			// Update la societe seule sans les personnes
			$.ajax({
				url : "SocieteServlet?" + societeToUpdate,
				type : "PUT",
				dataType : "html",
				success : function(res, status) {
					$("#societesTbody").html(res);
					
					// Icone du bouton "btn-voir" sur "visibility_off" pour eleve courant
					$("#societesTbody")
						.find(".btn-voir[data-idsociete=" + idSocieteTxt + "]").addClass("btn-success")
							.find("i").empty().text("visibility_off").end()
							.trigger("click"); // Reactualiser l'affichage des personnes
				}
			});
		});	
	});
	
	
	

	// MODAL: Supprimer une personne d une societe
	$("#editSocieteModal").on("click", ".btn-modal-delete", function() {
		$this = $(this);
		
		const idSociete = $("#editSocieteModal").find("input[name=idSociete]").val();
		const idPersonne = $(this).closest("tr").find("input[name=idPersonne]").val();
		alert(idSociete + "" + idPersonne)

		$.ajax({
			url: "SocieteServlet?action=DELETE_PERSONNE&idSociete=" + idSociete + "&idPersonne=" + idPersonne,
			type: "DELETE",
			//dataType: "html",
			success: function(res, status) {
				alert(status);
				
				$this.closest("tr").remove();
				
			}
		});

		

	});
		
	// Scroll to bloc collapseNotes
	$('#collapseNotes').on('shown.bs.collapse', function () {
		this.scrollIntoView();
	});
	
});