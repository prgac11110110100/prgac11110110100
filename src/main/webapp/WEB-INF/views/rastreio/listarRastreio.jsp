<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Alex Clemente">
<link rel="icon" href="resources/img/favicon.ico">
<title>Listar Rastreios</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="resources/css/starter-template.css" rel="stylesheet">
<link href="resources/css/sticky-footer-navbar.css" rel="stylesheet">
<link href="resources/css/footable/footable.core.min.css" rel="stylesheet" />

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="resources/js/ie-emulation-modes-warning.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="resources/js/ie10-viewport-bug-workaround.js"></script>

<!-- jQuery and Bootstrap JS -->
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/footable/footable.js"></script>
<script type="text/javascript" src="resources/js/rastreio.script.js"></script>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
					aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Teste de JAVA</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="home"><button class="btn btn-info">
								<span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home
							</button></a></li>
					<li><a href="formNovoRastreio"><button class="btn btn-success">
								<span class="glyphicon glyphicon-cloud" aria-hidden="true"></span> Incluir Rastro
							</button></a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div id="deletar-dado" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Confirme exclusao</h4>
				</div>

				<div class="modal-body">
					<p>Você vai excluir um registro, depois de feito não ha como recupera-lo mais.</p>
					<p>Tem certeza que quer fazer isso mesmo ?</p>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<a id="confirmaDelecao" class="btn btn-danger btn-ok">Excluir</a>
				</div>
			</div>
		</div>
	</div>
	<!-- ./modal -->
	<div class="container">
		<div id="#resultado" style="display: none" class="alert alert-danger text-center">
			<span class="glyphicon glyphicon-remove"></span> Rastreio excluido. 
		</div>
	</div>
	<div class="container table-responsive">
		<h2 class="text-center">Rastreabilidade</h2>
		<br />
		<table class="table toggle-circle-filled table-striped table-hover">
			<thead>
				<tr>
					<th class="col-md-0" data-toggle="true">Encomenda</th>
					<th class="text-left col-md-0" data-hide="tablet, dt_rastreio">Nota Fiscal</th>
					<th class="text-left col-md-0" data-hide="dt_rastreio">Dt Rastreio</th>
					<th class="text-right col-md-0">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="rastreio" items="${rastreios}">
					<tr>
						<td class="text-left">${rastreio.id_encomenda}</td>
						<td class="text-left">${rastreio.nota_fiscal}</td>
						<td class="text-left">${rastreio.dt_rastreio}</td>
						<td class="text-left">${rastreio.descr_encomenda}</td>
						<td class="text-left">${rastreio.situacao_rastreio}</td>
						<td class="text-right"><a
href="formAtualizarRastreio?id=${rastreio.id}&id_encomenda=${rastreio.id_encomenda}&nota_fiscal=${rastreio.nota_fiscal}&dt_rastreio=${rastreio.dt_rastreio}&descr_encomenda=${rastreio.descr_encomenda}&situacao_rastreio=${rastreio.situacao_rastreio}"							class="btn btn-info"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>editar</a> <a
							href="#deletar-dado" role="button" onclick="pegaId(${rastreio.id});" class="btn btn-danger" data-toggle="modal"
							data-target="#deletar-dado" class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- /.table -->
	</div>
	<!-- /.container -->
	<footer class="footer navbar-fixed-bottom">
		<div class="container">
			<p class="text-muted text-center">
				&copy; 2022 | Alex Clemente
			</p>
		</div>
	</footer>
	<!-- /.footer -->
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("table").footable();
	});
</script>
</html>