<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Gestao BPM</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>

        function limpa_formulário_cep() {
            //Limpa valores do formulário de cep.
            document.getElementById('rua').value=("");
            document.getElementById('bairro').value=("");
            document.getElementById('cidade').value=("");
            document.getElementById('uf').value=("");

        }

        function meu_callback(conteudo) {
            if (!("erro" in conteudo)) {
                //Atualiza os campos com os valores.
                document.getElementById('rua').value=(conteudo.logradouro);
                document.getElementById('bairro').value=(conteudo.bairro);
                document.getElementById('cidade').value=(conteudo.localidade);
                document.getElementById('uf').value=(conteudo.uf);

            } //end if.
            else {
                //CEP não Encontrado.
                limpa_formulário_cep();
                alert("CEP não encontrado.");
            }
        }

        function pesquisacep(valor) {

            //Nova variável "cep" somente com dígitos.
            var cep = valor.replace(/\D/g, '');

            //Verifica se campo cep possui valor informado.
            if (cep != "") {

                //Expressão regular para validar o CEP.
                var validacep = /^[0-9]{8}$/;

                //Valida o formato do CEP.
                if(validacep.test(cep)) {

                    //Preenche os campos com "..." enquanto consulta webservice.
                    document.getElementById('rua').value="...";
                    document.getElementById('bairro').value="...";
                    document.getElementById('cidade').value="...";
                    document.getElementById('uf').value="...";


                    //Cria um elemento javascript.
                    var script = document.createElement('script');

                    //Sincroniza com o callback.
                    script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

                    //Insere script no documento e carrega o conteúdo.
                    document.body.appendChild(script);

                } //end if.
                else {
                    //cep é inválido.
                    limpa_formulário_cep();
                    alert("Formato de CEP inválido.");
                }
            } //end if.
            else {
                //cep sem valor, limpa formulário.
                limpa_formulário_cep();
            }
        };

    </script>

    <style type="text/css">
        .checkbox-grid li {
            display: block;
            float: left;
            width: 25%;
        }
    </style>
</head>
<body>

<c:import url="/WEB-INF/jsp/cabecalho.jsp"/>
<c:set var="botao" value=""/>
    <div class="container">
        <form action="/batalhao/incluir" method="post">

            <div class="form-group">
                <label style = "font-size:x-large;" >Nome:</label>
                <input type="text" class="form-control"  placeholder="Entre com o nome do bpm" name="nome" value="Mathias de albuquerque" size="50">
            </div>

            <div class="form-group">
                <label>Area:</label>
                <select class="form-control" name="area">
                    <option value="25BPM">25BPM</option>
                    <option selected value="1BPM">1BPM</option>
                    <option value="11BPM">11BPM</option>
                    <option value="12BPM">12BPM</option>
                    <option value="16BPM">16BPM</option>
                    <option value="20BPM">20BPM</option>
                </select>
            </div>
            <div class="form-group">
                <c:if test="${not empty policiais}">
                    <label>Policiais disponíveis:</label>
                    <c:forEach var="p" items="${policiais}">
                        <ul class="checkbox-grid">
                            <li><input type="checkbox" name="policiaisIds" value="${p.id}" /><label>${p.patente} ${p.nome}</label></li>
                        </ul>
                    </c:forEach>
                </c:if>
                <c:if test="${empty policiais}">
                    <label>Não existem policiais cadastrados!!!</label><br>
                    <a href="/oficial">Cadastrar Oficial</a><br><a href="/praca">Cadastrar Praca</a><br><a href="/reserva">Cadastrar Reserva</a>
                    <c:set var="botao" value="disabled"/>
                </c:if>
            </div>
            <div class="form-group">
                <label >CEP:</label>
                <input type="text" class="form-control" value=""  placeholder="Seu cep" name="cep" id="cep" size="10" maxlength="9" onblur="pesquisacep(this.value);"/>
            </div>
            <div class="form-group">
                <label >Logradouro:</label>
                <input type="text" class="form-control"  placeholder="Sua rua" name="rua" size="60" id="rua"/>
            </div>
            <div class="form-group">
                <label >Complemento:</label>
                <input type="text" class="form-control"  placeholder="Complemento" name="complemento" size="40" id="complemento">
            </div>
            <div class="form-group">
                <label >Bairro:</label>
                <input type="text" class="form-control"  placeholder="Seu bairro" name="bairro" id="bairro" size="40"/>
            </div>
            <div class="form-group">
                <label >Localidade:</label>
                <input type="text" class="form-control"  placeholder="cidade" name="cidade" id="cidade" size="40"/>
            </div>
            <div class="form-group">
                <label >UF:</label>
                <input type="text" class="form-control"  placeholder="UF" name="uf" id="uf" size="2">
            </div>

            <button type="submit" class="btn btn-primary" ${botao}>Cadastrar</button>
        </form>
    </div>'

</body>
</html>