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
    <c:if test="${not empty oficial}">
        <div class="alert alert-success">
            <strong>Confirma��o!</strong> ${oficial.patente} ${oficial.nome} foi cadastrado com sucesso
        </div>

    </c:if>
    <c:if test="${not empty lista}">

        <h4>
            Oficiais cadastrados no batalh�o: (${lista.size()}):
        </h4>
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Nome</th>
                <th>Matricula</th>
                <th>Patente</th>
                <th>Batalhao</th>
                <th>Quadro</th>
                <th>Secao</th>
                <th>Companhia</th>
                <th>Funcao</th>
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
                    <td>${c.quadro}</td>
                    <td>${c.secao}</td>
                    <td>${c.companhia}</td>
                    <td>${c.funcao}</td>
                    <td>${c.usuario.nome}</td>
                    <c:if test="${user.admin}">
                        <td><a href="/oficial/${c.id}/excluir">Excluir</a></td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>
    <c:if test="${empty lista}">
        <div class="alert alert-info">
            <strong>Opa...</strong> N�o existe oficiais cadastrados.
        </div>
    </c:if>
    <c:if test="${user.admin}">
        <a href="/oficial">Cadastrar Oficial</a>
    </c:if>
</div>
</body>
</html>