<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<c:url value="/" var="rootUrl" />
	<h2>Bienvenue sur votre espace personnel</h2>
	<h3>Opérations</h3>
	<ul>
		<li><a href="${rootUrl}">Retrait en espèce</a></li>
		<li><a href="${rootUrl}">Retrait d'une CB</a></li>
		<li><a href="${rootUrl}">Demande de chéquier</a></li>
		<li><a href="${rootUrl}">Effectuer un virement</a></li>
	</ul>
</body>
</html>