/**
 * AJAX JQuery
 */

$(document).ready(function(){
	$("#cmdSubmit").on("click", function() {
		 $.ajax({
	       url : './myServlet', // La ressource ciblée
	       type : 'GET', // Le type de la requête HTTP.
	       data : 'txtNombre1=' + $("#txtNombre1").val() + "&txtNombre2=" + $("#txtNombre2").val(),
	       dataType: "html",
	       success : function(res, status){ // code_html contient le HTML renvoyé
	           $("#resultat").html(res);
	       }
	    });
	});
});