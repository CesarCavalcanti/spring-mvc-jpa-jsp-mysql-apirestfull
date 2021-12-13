<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de usuários</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<c:import url="/WEB-INF/jsp/cabecalho.jsp"/>
<div class="container">
    <c:if test="${not empty usuario}">
        <div class="alert alert-success">
            <strong>Confirmação!</strong> Administrador ${nomeUsuario} foi cadastrado com sucesso
        </div>
    </c:if>

    <c:if test="${not empty lista}">

        <h4>
            Todos usuários cadastrados (${lista.size()}):
        </h4>
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Policiais cadastrados</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="u" items="${lista}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.nome}</td>
                    <td>${u.email}</td>
                    <td>${u.policiais.size()}</td>
                    <c:if test="${user.admin}">
                        <td><a href="/usuario/${u.id}/excluir">
                            <c:choose>
                                <c:when test = "${user.id != u.id}">
                                    Excluir
                                </c:when>
                            </c:choose>
                            </a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>
    <c:if test="${empty lista}">
        <div class="alert alert-info">
            <strong>Opa...</strong> Não existe usuarios cadastrados.
        </div>
    </c:if>
</div>
</body>
</html>