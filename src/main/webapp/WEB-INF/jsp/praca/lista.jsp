<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de oficiais</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<c:import url="/WEB-INF/jsp/cabecalho.jsp"/>
<div class="container">
    <c:if test="${not empty praca}">
        <div class="alert alert-success">
            <strong>Confirma??o!</strong> ${praca.patente} ${praca.nome} foi cadastrado com sucesso
        </div>

    </c:if>
    <c:if test="${not empty lista}">

        <h4>
            Pracas cadastrados no batalh?o: (${lista.size()}):
        </h4>
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Nome</th>
                <th>Matricula</th>
                <th>Patente</th>
                <th>Batalhao</th>
                <th>Secao</th>
                <th>Companhia</th>
                <th>Cargo</th>
                <th>Usuario</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${lista}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.nome}</td>
                    <td>${c.matricula}</td>
                    <td>${c.patente}</td>
                    <td>${c.batalhao.area}</td>
                    <td>${c.secao}</td>
                    <td>${c.companhia}</td>
                    <td>${c.cargo}</td>
                    <td>${c.usuario.nome}</td>
                    <c:if test="${user.admin}">
                        <td><a href="/praca/${c.id}/excluir">Excluir</a></td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>
    <c:if test="${empty lista}">
        <div class="alert alert-info">
            <strong>Opa...</strong> N?o existe pracas cadastrados.
        </div>
    </c:if>
    <c:if test="${user.admin}">
        <a href="/praca">Cadastrar Praca</a>
    </c:if>
</div>
</body>
</html>