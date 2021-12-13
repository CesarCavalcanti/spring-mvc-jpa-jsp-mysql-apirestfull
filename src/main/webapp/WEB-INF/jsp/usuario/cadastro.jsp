<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de usuários</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="/WEB-INF/jsp/cabecalho.jsp"/>
<div class="container">
    <form action="/usuario/incluir" method="post">

        <div class="form-group">
            <label style = "font-size:x-large;">Nome:</label>
            <input type="text" class="form-control"  placeholder="Entre com seu nome" name="nome" value="Junior">
        </div>

        <div class="form-group">
            <label style = "font-size:x-large;">E-mail:</label>
            <input type="email" class="form-control"  placeholder="Entre com seu e-mail" name="email" value="bbb@gmail.com">
        </div>

        <div class="form-group">
            <label style = "font-size:x-large;">Senha:</label>
            <input type="password" class="form-control"  placeholder="Entre com sua senha" name="senha" value="123">
        </div>
        <div class="form-group">
            <label>Administrador?</label>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" name="admin" class="form-check-input" value="true"> SIM
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" name="admin" class="form-check-input" value="false"> NAO
                </label>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</div>

</body>
</html>