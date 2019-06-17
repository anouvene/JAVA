$(function(){
	
	// GET
	$("#get").on("click", function(){
		$.ajax({
			url: "/JAX_RS_JERSEY/rest/adelium",
			type: "GET",
			ContentType: "application/json",
			dataType: "json",
			success: function(personne, status) {
				const infosPersonne = "<ul><li>" + personne.nom + "</li><li>" + personne.prenom + "</li><li>" + personne.message + "</li></ul>";
				$("#getBody").html(infosPersonne);
			},
			error: function(err) {
				console.log(err);
			}			
		});
	});
	
	// POST
	$("#post").on("click", function(){
		$.ajax({
			url: "/JAX_RS_JERSEY/rest/adelium",
			type: "POST",
			ContentType: "application/json",
			dataType: "text",
			success: function(res, status) {
				$("#postBody").html(res);
			},
			error: function(err) {
				console.log(err);
			}			
		});
	});
	
	// PUT
	$("#put").on("click", function(){
		$.ajax({
			url: "/JAX_RS_JERSEY/rest/adelium",
			type: "PUT",
			ContentType: "application/json",
			dataType: "text",
			success: function(res, status) {
				$("#putBody").html(res);
			},
			error: function(err) {
				console.log(err);
			}			
		});
	});
	
	// DELETE
	$("#delete").on("click", function(){
		$.ajax({
			url: "/JAX_RS_JERSEY/rest/adelium",
			type: "DELETE",
			ContentType: "application/json",
			dataType: "text",
			success: function(res, status) {
				$("#deleteBody").html(res);
			},
			error: function(err) {
				console.log(err);
			}			
		});
	});
});