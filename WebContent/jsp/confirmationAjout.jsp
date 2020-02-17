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
<title>Confirmation ajout de produit</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header border text-center">detail de produit ajouté</div>
			<div class="card-body">
				<div class="card-body rounded border border-info">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">ID : </label>
						<label>${produitP.id}</label>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Designation : </label>
						<label>${produitP.designation }</label>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Prix : </label>
						<label>${produitP.prix }</label>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Quantité : </label>
						<label>${produitP.quantite}</label>
					</div>

				</div>

			</div>
		</div>

	</div>
</body>
</html>