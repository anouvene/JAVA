$(function(){
	let choix = $("input:radio:checked").val();
	let couleur = "000000";
	
	$("form").on("click", "input:radio", function() {
		if($(this).is(":checked")) {
			choix = $(this).val();
		}	
	});
	
	$("form").on("change", $("select"), function() {
		couleur = $("option:selected", $(this)).val();
		alert(couleur);
		
		if(choix === "Texte") {
			$("#txtZone").css({"background-color" : "white" , "color" : "#" + couleur});
		} else if($("option:selected").val() !== ""){
			if (couleur === "ffffff") { // Fond blanc et texte noir
				$("#txtZone").css({"background-color": "#" + couleur, "color" : "black"});
			} else {
				$("#txtZone").css({"background-color": "#" + couleur, "color" : "white"});
			}
			
		} else {
			
			$("#txtZone").css({"background-color": "white", "color" : "black"});
		}
	});
	
});