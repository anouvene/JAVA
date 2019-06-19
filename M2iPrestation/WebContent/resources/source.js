$(document).ready(function(){
	let lstProduits = [];
	function genererProduit(produits){
		let options = "";
		let optiondefault = "<option value=0>Choisir un produit</option>";
		options += optiondefault;
		for(let p of produits) {
		let option= "<option value ="+ p.id_produit+">"+p.intitule + "</option>";
		options += option;
		}
		$("#lstproduits").html(options);
	}
	
	$.ajax({
		url:"commande",
		type:"GET",
		dataType : "JSON", 
		success : function(produits,status){
			lstProduits=produits;
			genererProduit(produits);
		}	
	});
		
	function getPrix(produit){
		return produit.pj_ht;
	}
	
	function getDuree(produit){
		return produit.nb_jours;
	}
	
	$("#lstproduits").change(function(){
		let produit = null;
		for(let p of lstProduits){
			if(	$(this).val() == p.id_produit){
				produit = p;
			}
		}
			
		$("#idPJAT").val(getPrix(produit));
		$("#idNbrJours").val(getDuree(produit));
	});	
});
