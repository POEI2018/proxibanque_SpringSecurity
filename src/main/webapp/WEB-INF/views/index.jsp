<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil Proxibanque v3</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty searchId}">
			<form method="post">
				<div class="form-group">
					<label for="keywords">Entrez vos nom et prénom</label>
					<input id="keywords" name="keywords" />
				</div>
				<button class="btn btn-success">Rechercher</button>
			</form>
		</c:when>
		<c:otherwise>
			<form action="<c:url value="/${searchId}/validate.html" />" method="post">
				<div class="form-group">
					<label for="birthdate">Entrez votre date de naissance</label>
					<input type="date" id="birthdate" name="birthdate" />
				</div>
				<button class="btn btn-success">Valider</button>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>