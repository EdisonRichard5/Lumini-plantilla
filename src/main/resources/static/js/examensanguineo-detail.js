function addDetail(){
	var detail = {
			tipoexamenid : $("#cmbTipo").val(),
			costefinal : $("#txtValor").val()
	}
	console.log(detail);
	
	$.ajax({
		url : "/master/addDetail/",
		method : 'POST',
		headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify(detail),
		success : function(response){
			$("#tblDetalle").html("");
			console.log(response);
			$.each(response, function(i, item){
				console.log(item);
				$("#tblDetalle").append("<tr>");
				$("#tblDetalle").append("<td>" + item.tipoServicio.tipo + "</td>");
				$("#tblDetalle").append("<td>" + item.costefinal + " </td>");
			//	$("#tblDetalle").append("<td> Normal : " + item.tipoExamen.rangoNormal + "</td>");
				$("#tblDetalle").append("</tr>");				
			});						
		},
		error : function(err){
			console.log(err);
		}		
	});
}

$(document).ready(function(){
	$("#btnAgregar").click(function(){
		addDetail();
	});
});
