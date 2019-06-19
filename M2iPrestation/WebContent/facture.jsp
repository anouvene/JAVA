<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="java.lang.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Page facture</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="./resources/source.js"></script>
</head>

<body>
	<div class="jumbotron text-center">
		<h1>Facture</h1>
		<p>A project by Tuan, Severine, Anis and Michael</p>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-5 offset-sm-2">
				<div class="card">
					<div class="card-header">
						Référence client:
						<%
							out.println(request.getAttribute("ref_client"));
						%>
					</div>
					<div class="card-body">
						<ul class="list-group">
							<li class="list-group-item">Intitule: <%
								out.println(request.getAttribute("intitule"));
							%></li>
							<li class="list-group-item">NBR DE JOURS: <%
								out.println(request.getAttribute("duree"));
							%></li>
							<li class="list-group-item">prix journalier HT: <%
								out.println(request.getAttribute("prixht"));
							%></li>
						</ul>
					</div>
					<div class="card-footer">
						TVA: 19.6 - Total TTC
						<%
							float HT = (Float) request.getAttribute("prixht");
							float TTC = HT * 0.196f;
							out.println(TTC);
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>