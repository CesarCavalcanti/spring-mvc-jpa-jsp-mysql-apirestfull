<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Cadastro de oficiais</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>

        function limpa_formul�rio_cep() {
            //Limpa valores do formul�rio de cep.
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
                //CEP n�o Encontrado.
                limpa_formul�rio_cep();
                alert("CEP n�o encontrado.");
            }
        }

        function pesquisacep(valor) {

            //Nova vari�vel "cep" somente com d�gitos.
            var cep = valor.replace(/\D/g, '');

            //Verifica se campo cep possui valor informado.
            if (cep != "") {

                //Express�o regular para validar o CEP.
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

                    //Insere script no documento e carrega o conte�do.
                    document.body.appendChild(script);

                } //end if.
                else {
                    //cep � inv�lido.
                    limpa_formul�rio_cep();
                    alert("Formato de CEP inv�lido.");
                }
            } //end if.
            else {
                //cep sem valor, limpa formul�rio.
                limpa_formul�rio_cep();
            }
        };

    </script>
</head>
<body>

<c:import url="/WEB-INF/jsp/cabecalho.jsp"/>
<div class="container">
    <form action="/reserva/incluir" method="post">

        <div class="form-group">
            <label style = "font-size:x-large;" >Nome:</label>
            <input type="text" class="form-control"  placeholder="Entre com seu nome" name="nome" value="Cesar de sena" size="50">
        </div>

        <div class="form-group">
            <label style = "font-size:x-large;">Matricula:</label>
            <input type="text" class="form-control"  placeholder="Entre com sua matricula" name="matricula" value="1235578" size="30">
        </div>

        <div class="form-group">
            <label style = "font-size:x-large;">Celular:</label>
            <input type="text" class="form-control"  placeholder="Entre com seu n�mero" name="celular" value="81996924416" size="30">
        </div>
        <div class="form-group">
            <label style = "font-size:x-large;">Idade:</label>
            <input type="text" class="form-control"  placeholder="Entre com sua idade" name="idade" value="65" size="30">
        </div>

        <div class="form-group">
            <label>Patente:</label>
            <select class="form-control" name="patente">
                <option value="Soldado RR">Soldado RR</option>
                <option selected value="Cabo RR">Cabo RR</option>
                <option value="3 Sargento RR">3� Sargento RR</option>
                <option value="2 Sargento RR">2� Sargento RR</option>
                <option value="1 Sargento RR">1� Sargento RR</option>
                <option value="Sub Tenente RR">Sub Tenente RR</option>
            </select>
        </div>

        <div class="form-group">
            <label>Lotacao:</label>
            <select class="form-control" name="lotacao">
                <option value="Guarda patrimonial">Guarda patrimonial</option>
                <option selected value="Patrulha escolar">Patrulha escolar</option>
                <option value="Guarda especial">Guarda especial</option>
                <option value="Ajudancia">Ajudancia</option>
            </select>
        </div>
        <div class="form-group">
            <label style = "font-size:x-large;">Matricula especial:</label>
            <input type="text" class="form-control"  placeholder="Entre com sua matricula especial" name="matriculaEspecial" value="123557822222" size="30">
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

        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
</div>'

</body>
</html>