<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="redirect:/">Gestao BPM</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Inicio</a></li>
            <c:if test="${not empty user}">
                <li><a href="/pracas">Pracas</a></li>
                <li><a href="/oficiais">Oficiais</a></li>
                <li><a href="/reservas">Reserva Remunerada</a></li>
                <li><a href="/viaturas">Viaturas</a></li>
            </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty user}">
                <li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Cadastrar</a></li>
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:if>
            <c:if test="${not empty user}">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${user.nome}</a></li>
            </c:if>
        </ul>
    </div>
</nav>
