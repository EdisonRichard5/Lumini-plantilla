function listAntecedentePatologicoPersonal(){
	var id = $("#idpersona").val();
	$.ajax({
		url : "/antecedentePatologicoPersonal/list/" + id,
		method : 'GET',
		success : function(response){
			$("#ctnAntecedentePatologicoPersonal").empty();
			$("#ctnAntecedentePatologicoPersonal").html(response);
		},
		error : function(err){
			console.log(err);
		}		
	});
}


function createAntecedentePatologicoPersonal(){
	var id = $("#idpersona").val();
	$.ajax({
		url : "/antecedentePatologicoPersonal/create/" + id,
		method : 'GET',
		success : function(response){
			$("#ctnAntecedentePatologicoPersonal").empty();
			$("#ctnAntecedentePatologicoPersonal").html(response);
		},
		error : function(err){
			console.log(err);
		}		
	});
}


$(document).ready(function(){
	listAntecedentePatologicoPersonal();
	
	$("#btnAgregarAntecedente").click(function(){
		createAntecedentePatologicoPersonal();
	});
	
});
