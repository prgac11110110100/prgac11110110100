/* ajax form novoRastreio*/
$(document).ready(function() {
	$("#formRastreio").submit(function() {
		var id_encomenda = $("#id_encomenda").val();
		var descr_encomenda = $("#descr_encomenda").val();
		var nota_fiscal = $("#nota_fiscal").val();
		var situacao_rastreio = $("#situacao_rastreio").val(); 
		var dt_rastreio = $("#dt_rastreio").val();
			$.ajax({
				url : "novoRastreio",
				type : "POST",
				dataType : "html",
				data : {
					id_encomenda : id_encomenda,
					descr_encomenda : descr_encomenda,
					nota_fiscal : nota_fiscal,
					situacao_rastreio : situacao_rastreio, 
					dt_rastreio : dt_rastreio 
				},
				success : function(dados) {

				},
				statusCode : {
					200 : success
				}
			});
		return false;
	});
});

function redirectListarRastreios() {
	window.setTimeout(function() {
		var raiz = window.location.origin;
		var projeto = "/alexclemente-testejava";
		var action = "/listarRastreios"

		var urlTomcat = raiz + projeto;
		var urlJetty = raiz;
		var urlAtual = window.location.href;


         console.log("urlTomcat "+ urlTomcat); 
         console.log("urlJetty "+ urlJetty); 

		if (window.location.href === urlTomcat + "/formNovoRastreio") {
			window.location = urlTomcat + action;
		} else if (window.location.href === urlTomcat + "/novoRastreio") {
			window.location = urlTomcat + action;
		} else if (window.location.href === urlJetty + "/formNovoRastreio"){
			window.location = urlJetty + action;
		} else if (urlAtual.match(/alexclemente-testejava/)){
			window.location = urlTomcat + action;
		} else if (urlAtual.match(/formAtualizarRastreio/)){
			window.location = urlJetty + action;
		}
	}, 3000);

}

function success() {
	$("div.alert-success").fadeIn(300).delay(2500).fadeOut(400);
	document.getElementById('id_encomenda').value = '';
	document.getElementById('descr_encomenda').value = '';
	document.getElementById('nota_fiscal').value = '';
	document.getElementById('situacao_rastreio').value = '';
	document.getElementById('dt_rastreio').value = '';
	redirectListarRastreios();
}
/* fim */

/* listar rastreios da action excluir */
function pegaId(getId){
console.log(getId);
	$("#confirmaDelecao").click(function(){
		excluir(getId);
		$('.modal').modal('hide');
		
	});
}

function excluir(id){
	$.get("excluirRastreio?id=" + id, deuCerto);
}

function deuCerto(dados){
	successDelete();

	$.ajax({
		url : "listarRastreios",
		type : "GET",
		dataType : "html",
		success : function(dados) {	
			window.setTimeout('location.reload()', 2000);
		}
	});
}

function successDelete(){
	$("div.alert-danger").fadeIn(300).delay(2000).fadeOut(400);
}
/* fim */
/* ajax form atualizarRastreio */
$(document).ready(function() {
	$("#formAtualizarRastreio").submit(function() {	
		var id_encomenda = $("#id_encomenda").val();
		var descr_encomenda = $("#descr_encomenda").val();
		var nota_fiscal = $("#nota_fiscal").val();
		var situacao_rastreio = $("#situacao_rastreio").val(); 
		var dt_rastreio = $("#dt_rastreio").val();
			$.ajax({
				url : "atualizarRastreio",
				type : "POST",
				dataType : "html",
				data : {
					id_encomenda : id_encomenda,
					descr_encomenda : descr_encomenda,
					nota_fiscal : nota_fiscal,
					situacao_rastreio : situacao_rastreio, 
					dt_rastreio : dt_rastreio 
				},
				success : function(dados) {

				},
				statusCode : {
					200 : success
				}
			});
		return false;
	});
});
