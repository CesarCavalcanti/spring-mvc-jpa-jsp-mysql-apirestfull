<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Gestão de BPM</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<c:import url="/WEB-INF/jsp/cabecalho.jsp"/>

<div class="container">

    <c:if test="${not empty nome}">
        <div class="alert alert-sucess">
            <strong>Usuário ${nome} cadastrado com sucesso!!!</strong>
        </div>
    </c:if>

    <c:if test="${not empty user}">
        <h3>Olá, ${user.nome}, Seja bem vindo!!</h3>
    </c:if>
</div>
</body>
</html>