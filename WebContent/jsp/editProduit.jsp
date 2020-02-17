<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Edition de Produits</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header border text-center">Edition de Produits</div>
			<div class="card-body">
				<form action="update.do" method="post">
				<div class="form-group row">
						<label class="col-sm-2 col-form-label">Id</label>
						<div class="col-sm-10">
							<input name="id" value="${produitP.id }" required="required" class="form-control" type="text">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Designation</label>
						<div class="col-sm-10">
							<input name="designation" value="${produitP.designation }" required="required" class="form-control" type="text">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Prix</label>
						<div class="col-sm-10">
							<input name="prix" value="${produitP.prix }" class="form-control" type="text">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">Quantité</label>
						<div class="col-sm-10">
							<input name="quantite" value="${produitP.quantite }" class="form-control" type="text">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-5 ">
							<button type="submit" class="btn btn-success ">Valider</button>
						</div>
					</div>
				</form>
				
			</div>
		</div>

	</div>
</body>
</html>