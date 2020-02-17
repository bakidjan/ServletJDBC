<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Produits</title>
</head>
<body>
<%@include file="header.jsp" %>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header border text-center">Produits</div>
			<div class="card-body">
				<form action="chercher.do" method="get">
					<label>Mot clé</label> 
					<input type="text" name="motCle" value="${model.motCle}">
					<button type="submit" class="btn btn-primary">Chercher</button>
				</form>
				<table class="table">
				<thead><tr>
				<th>ID</th>
				<th>DESIGNATION</th>
				<th>PRIX</th>
				<th>QUANTITE</th>
				</tr></thead>
				<tbody>
				<c:forEach items="${model.produits}" var="p">
				<tr>
				<td>${p.id}</td>
				<td>${p.designation}</td>
				<td>${p.prix}</td>
				<td>${p.quantite}</td>
				<td ><a onclick="return confirm('Are you sure to delete?')" href="supprimer.do?id=${p.id }" class="fa fa-trash" style="color:red"></a></td>
				<td ><a href="edit.do?id=${p.id }" class="fa fa-edit" style="color:blue"></a></td>
				</tr>
				</c:forEach>
				</tbody>
				</table>
			</div>
		</div>
		
	</div>
</body>
</html>