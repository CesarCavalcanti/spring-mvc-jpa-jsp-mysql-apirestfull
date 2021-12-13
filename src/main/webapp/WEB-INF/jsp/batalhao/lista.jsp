<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gestao BPM</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<c:import url="/WEB-INF/jsp/cabecalho.jsp"/>
<div class="container">
    <c:if test="${not empty batalhao}">
        <div class="alert alert-success">
            <strong>Confirmação!</strong> ${batalhao.area} ${batalhao.nome} foi cadastrado com sucesso
        </div>

    </c:if>
    <c:if test="${not empty lista}">

        <h4>
            Batalhoes cadastrados: (${lista.size()}):
        </h4>
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Nome</th>
                <th>Area</th>
                <th>Endereco</th>
                <th>Policiais Efetivos</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${lista}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.nome}</td>
                    <td>${c.area}</td>
                    <td>${c.endereco.rua}</td>
                    <td>${c.policiais.size()}</td>
                    <c:if test="${user.admin}">
                        <td><a href="/batalhao/${c.id}/excluir">Excluir</a></td>
                    </c:if>
                    <td><a href="/batalhao/${c.id}/buscar">Ver todos os PMs</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>
    <c:if test="${empty lista}">
        <div class="alert alert-info">
            <strong>Opa...</strong> Não existe batalhoes cadastrados.
        </div>
    </c:if>
    <c:if test="${user.admin}">
        <a href="/batalhao">Cadastrar Batalhao</a>
    </c:if>
</div>
</body>
</html>