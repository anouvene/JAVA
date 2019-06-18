$(document).ready(function() {

	$.ajax({
		url : "commande",
		type : "GET",
		dataType : "JSON",
		success : function(produits, status) {
			console.log(produits);
		}
	})

})
