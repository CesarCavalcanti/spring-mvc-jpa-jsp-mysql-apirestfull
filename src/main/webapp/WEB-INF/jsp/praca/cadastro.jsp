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
</head>
<body>

<c:import url="/WEB-INF/jsp/cabecalho.jsp"/>
<div class="container">
    <form action="/praca/incluir" method="post">

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
            <input type="text" class="form-control"  placeholder="Entre com seu número" name="celular" value="81996924416" size="30">
        </div>

        <div class="form-group">
            <label>Patente:</label>
            <select class="form-control" name="patente">
                <option value="Soldado">Soldado</option>
                <option selected value="Cabo">Cabo</option>
                <option value="3 Sargento">3º Sargento</option>
                <option value="2 Sargento">2º Sargento</option>
                <option value="1 Sargento">1º Sargento</option>
                <option value="Sub Tenente">Sub Tenente</option>
            </select>
        </div>

        <div class="form-group">
            <label>Secao:</label>
            <select class="form-control" name="secao">
                <option value="Corpo de Alunos">Corpo de Alunos</option>
                <option selected value="Divisao de ensino">Divisao de ensino</option>
                <option value="Divisao administrativa">Divisao administrativa</option>
                <option value="Comando">Comando</option>
                <option value="Smap">Smap</option>
                <option value="Armaria">Armaria</option>
            </select>
        </div>
        <div class="form-group">
            <label>Companhia:</label>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" name="companhia" class="form-check-input" value="1"> 1ª Companhia
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" name="companhia" class="form-check-input" value="2"> 2ª Companhia
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" name="companhia" class="form-check-input" value="3"> 3ª Companhia
                </label>
            </div>
        </div>
        <div class="form-group">
            <label>Cargo:</label>
            <select class="form-control" name="cargo">
                <option value="Encarregado">Encarregado</option>
                <option selected value="Secretario">Secretario</option>
                <option value="Auxiliar">Auxiliar</option>
            </select>
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