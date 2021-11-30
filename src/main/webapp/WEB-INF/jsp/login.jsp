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

        <h2>Tela de login</h2>

        <c:if test="${not empty msg}">
            <div class="alert alert-danger">
                <strong>Alerta!</strong> ${msg}
            </div>
        </c:if>

        <form action="/login" method="post">

            <div class="form-group">
                <label>Email:</label>
                <input type="email" class="form-control"  placeholder="Entre com email" value="bangjogos1@gmail.com" name="email">
            </div>

            <div class="form-group">
                <label>Password:</label>
                <input type="password" class="form-control"  placeholder="Entre com a senha" value="123" name="senha">
            </div>

            <button type="submit" class="btn btn-primary">Entrar</button>

        </form>
    </div>
</body>
</html>