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
<title>Transp - pagina inicial</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="resources/css/starter-template.css" rel="stylesheet">
<link href="resources/css/sticky-footer-navbar.css" rel="stylesheet">

<link href="resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<script src="resources/js/ie-emulation-modes-warning.js"></script>
<script src="resources/js/ie10-viewport-bug-workaround.js"></script>

<script type="text/javascript" src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
					aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">barra navegacao</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Teste de JAVA</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="listarRastreios"><button class="btn btn-info">
								<span class="glyphicon glyphicon-th-list" style="color:green" aria-hidden="true"></span> Ver Rastreio
							</button></a></li>
					<li><a href="formNovoRastreio"><button class="btn btn-success">
								<span class="glyphicon glyphicon-cloud" aria-hidden="true"></span> Incluir Rastro
							</button></a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="starter-template">
			<h1 class="text-center">Transp - rastreabilidade</h1>
		</div>
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
</html>