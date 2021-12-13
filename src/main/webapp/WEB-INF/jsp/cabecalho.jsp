<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/gestaobpm">GestaoBPM</a>
        </div>
        <ul class="nav navbar-nav">
                <c:if test="${user.admin}">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastrar <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                                <li><a href="/batalhao">Batalhao</a></li>
                                <li><a href="/oficial">Oficial</a></li>
                                <li><a href="/praca">Praca</a></li>
                                <li><a href="/reserva">Reserva</a></li>
                                <li><a href="/usuario">Administradores</a></li>
                        </ul>
                    </li>
                </c:if>
            <c:if test="${not empty user}">
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Ver todos <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/batalhoes">Batalhoes</a></li>
                        <li><a href="/oficiais">Oficiais</a></li>
                        <li><a href="/pracas">Pracas</a></li>
                        <li><a href="/reservas">Reservas</a></li>
                        <c:if test="${user.admin}">
                            <li><a href="/usuarios">Administradores</a></li>
                        </c:if>
                    </ul>
                </li>
            </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-left">
            <c:if test="${not empty user}">
                <li><a href="/policiais">Todos os policiais</a></li>
            </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty user}">
                <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:if>
            <c:if test="${user.admin}">
                <li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Cadastrar ADM</a></li>
            </c:if>
            <c:if test="${not empty user}">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${user.nome}</a></li>
            </c:if>
        </ul>
    </div>
</nav>
