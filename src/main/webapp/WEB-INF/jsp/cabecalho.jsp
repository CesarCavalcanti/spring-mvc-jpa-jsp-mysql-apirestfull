<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<nav class="navbar navbar-inverse">--%>
<%--    <div class="container-fluid">--%>
<%--        <div class="navbar-header">--%>
<%--            <a class="navbar-brand" href="redirect:/">Gestao BPM</a>--%>
<%--        </div>--%>
<%--        <ul class="nav navbar-nav">--%>
<%--            <li class="active"><a href="#">Inicio</a></li>--%>
<%--            <c:if test="${not empty user}">--%>
<%--                <li><a href="/pracas">Pracas</a></li>--%>
<%--                <li><a href="/oficiais">Oficiais</a></li>--%>
<%--                <li><a href="/reservas">Reserva Remunerada</a></li>--%>
<%--                <li><a href="/viaturas">Viaturas</a></li>--%>
<%--            </c:if>--%>
<%--        </ul>--%>
<%--        <ul class="nav navbar-nav navbar-right">--%>
<%--            <c:if test="${empty user}">--%>
<%--                <li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Cadastrar</a></li>--%>
<%--                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>--%>
<%--            </c:if>--%>
<%--            <c:if test="${not empty user}">--%>
<%--                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${user.nome}</a></li>--%>
<%--            </c:if>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</nav>--%>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">GestaoBPM</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastro <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Batalhao</a></li>
                    <li><a href="/oficial">Oficial</a></li>
                    <li><a href="#">Praca</a></li>
                    <li><a href="#">Reserva</a></li>
                </ul>
            </li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Lista <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Batalhoes</a></li>
                    <li><a href="#">Oficiais</a></li>
                    <li><a href="#">Pracas</a></li>
                    <li><a href="#">Reservas</a></li>
                </ul>
            </li>
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
