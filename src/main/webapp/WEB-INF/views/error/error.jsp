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
<title>Error Page</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="resources/css/starter-template.css" rel="stylesheet">
<link href="resources/css/sticky-footer-navbar.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="resources/js/ie-emulation-modes-warning.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="resources/js/ie10-viewport-bug-workaround.js"></script>

<!-- jQuery and Bootstrap JS -->
<script type="text/javascript" src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
		<div class="row">
		    <div class="col-md-4"></div>
		    <div class="col-md-4">
			<c:choose>
				<c:when test="${statusCode != '500'}">
					<h2 class="text-center">Servlet 3 Exception Handling</h2>
					<ul class="list-group">
						<li class="list-group-item list-group-item-danger"><strong>Status Code:</strong> ${statusCode}</li>
						<li class="list-group-item list-group-item-info"><strong>Requested URI:</strong> ${requestUri}</li>
					</ul>
				</c:when>
				<c:otherwise>

					<h2 class="text-center">Servlet 3 Exception Handling</h2>
					<ul class="list-group">
						<li class="list-group-item list-group-item-info"><strong>Servlet Name:</strong> ${servletName}</li>
						<li class="list-group-item list-group-item-danger"><strong>Exception Name:</strong> ${exception.getClass().getName()}</li>
						 <li class="list-group-item list-group-item-success"><strong>Requested URI:</strong> ${requestUri}</li>
						<li class="list-group-item list-group-item-warning"><strong>Exception Message:</strong> ${exception.getMessage()}</li>
					</ul>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
	</div>
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