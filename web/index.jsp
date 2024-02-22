<%-- 07
    Document   : index
    Created on : 15 de fev. de 2024, 23:08:18
    Author     : nalis
--%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>natturHome</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="arquivo/css/estilo.css"/>
    <link rel="stylesheet" href="arquivo/css/cadastro.css"/>
    <link rel="stylesheet" href="arquivo/css/login.css"/>
    <link rel="stylesheet" href="arquivo/css/formularioCompra.css"/>
    <script src="arquivo/js/script.js"></script>
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  



</head>
<body>
     <header>
    <h1 class="nat">nattur</h1>
 
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <div class="container">
            <a class="navbar-brand text-white" href="#">nattur</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link text-white" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="index.jsp">Destino </a>
                       
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="index.jsp">Promoções</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="index.jsp">Contatos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="index.jsp">Oferta</a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <button id="btn-inscrever" class="btn btn-primary">Inscrever</button>
                    </li>
                     <li class="nav-item">
                        <!-- top 2: Botão "Ir para Login" -->
                        <button id="btn-ir-para-login" class="btn btn-primary">Ir para Login</button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <hr>
</header>

<main>
    <div class="container mt-4">      
    
    <h2 class="text-primeiro">Bem-vindo à nattur, a agência de viagens online</h2>
    <p class="text-primeiro">
        
            Junte-se a nós para conhecer sua próxima grande aventura. Transforme seu sonho de viajar em realidade com um clique!
    </p>
  
       <!-- Formulário de Cadastro -->
<div id="cadastro" style="display: none;">
    <h2>Cadastro</h2>
    <form action="CadastroServlet" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required><br><br>
        <!-- Botão de cadastro -->
        <button type="submit">Cadastrar</button>
        <!-- Botão "Ir para Login" -->
        <button type="button" id="btn-ir-para-login" onclick="openLoginForm()">Ir para Login</button>
    </form>
</div>


        <!-- Formulário de Login -->
        <div id="login" style="display: none;">
            <h2>Login</h2>
            <form action="LoginServlet" method="post" id="form-login">
                <!-- Campos do formulário -->
                <label for="email_login">Email:</label>
                <input type="email" id="email_login" name="email_login" required><br><br>
                <label for="senha_login">Senha:</label>
                <input type="password" id="senha_login" name="senha_login" required><br><br>
                <!-- Botão de entrar -->
                <button type="submit" id="btn-entrar" class="btn btn-primary">Entrar</button>
            </form>
        </div>

        <h4 class="text-primeiro">Destino</h4>

<div id="formularioCompra" style="display: none;">
    <h2>Formulário de Compra</h2>
   

    <form id="formCompra" onsubmit="return enviarCompra()" style="margin-top: 20px;">
        <label for="passagem">Passagem:</label><br>
        <select id="passagem" name="passagem">
            <!-- Aqui você pode adicionar as opções de passagens disponíveis -->
            <option value="passagem1">São Paulo SP</option>
            <option value="passagem2">Rio de Janeiro RJ</option>
            <option value="passagem3">Fortaleza CE</option>
            <option value="passagem4">Manaus AM</option>
        </select><br><br>
        
        <label for="nome">Nome:</label><br>
        <input type="text" id="nome" name="nome" required><br><br>
        
        <label for="quantidade">Quantidade de Passagens:</label><br>
        <input type="number" id="quantidade" name="quantidade" min="1" required><br><br>
        
        <label for="data">Data de Partida:</label><br>
        <input type="date" id="data" name="data" required><br><br>
        
        <button type="submit">Finalizar Compra</button>
    </form>
    <p id="mensagemCompra" style="display: none; margin-top: 10px;">Compra realizada com sucesso!</p>
</div>


        <section id="destinos" class="container">
            <!-- Conteúdo dos destinos -->
        <table>
            <tr>

            <td>

        <article class="produto">
            <div class="imagem-container col-md-9">
                <img src="./imagem/MANAUS-1.jpg" alt="Manaus AM" class="img-fluid">
                <p>Manaus-AM</p>
            </div>
            <div class="info-produto col-md-8">
                <p>Descrição do produto e informações relevantes.</p>
                <p>Preço: $400.99</p>
               <button id="botaoComprar" class="btn btn-warning" onclick="mostrarFormularioCompra()">Compre Agora</button>


            </div>
        </article>
    </td>
    <td>
        <article class="produto">
            <div class="imagem-container col-md-9">
                <img src="./imagem/-Fortaleza.png" alt="Fortaleza-CE" class="img-fluid">
                <p>Fortaleza-CE</p>
            </div>
            <div class="info-produto col-md-8">
                <p>Descrição do produto e informações relevantes.</p>
                <p>Preço: $400.99</p>
             <button id="botaoComprar" class="btn btn-warning text-dark" onclick="mostrarFormularioCompra()">Compre Agora</button>


            </div>
        </article>
    </td>
    <td>
        <article class="produto">
            <div class="imagem-container col-md-9">
                <img src="./imagem/aniversario-rio-de-janeiro.jpg" alt="Rio de janeiro-RJ" class="img-fluid">
                <p>Rio de janeiro-RJ</p>
            </div>
            <div class="info-produto col-md-8">
                <p>Descrição do produto e informações relevantes.</p>
                <p>Preço: $400.99</p>
                <button id="botaoComprar" class="btn btn-warning" onclick="mostrarFormularioCompra()">Compre Agora</button>


            </div>
        </article>
    </td>
    <td>
        <article class="produto">
            <div class="imagem-container  col-md-9">
                <img src="./imagem/sao paulo.webp" alt="Sao Paulo-SP" class="img-fluid">
                <p>Sao Paulo-SP</p>
            </div>
            <div class="info-produto col-md-8">
                <p>Descrição do produto e informações relevantes.</p>
                <p>Preço: $400.99</p>
                <button id="botaoComprar" class="btn btn-warning" onclick="mostrarFormularioCompra()">Compre Agora</button>

            </div>
        </article>
    </td>
    </tr>

        </table>       
        </section>

        <br>
        <div class="text-center">
            <h5 class="um">Formas de pagamento</h5>
            <img src="imagem/Cartões.png" alt="Forma de pagamento" width="200" height="50">
        </div>
    </div>
</main>
    
<footer>
     <div class="bg-dark text-light text-center py-3"> <p>&copy; nattur recode</p> </div> 
</footer>
<br>
<br>
<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script>
    $(document).ready(function(){
        // Ao clicar no botão "Inscrever"
        $("#btn-inscrever").click(function(){
            $("#cadastro").show(); // Exibe o formulário de cadastro
            $("#login").hide();    // Oculta o formulário de login
        });

        // Ao clicar no botão "Ir para Login" no formulário de cadastro
        $("#btn-ir-para-login").click(function(){
            $("#login").show();    // Exibe o formulário de login
            $("#cadastro").hide(); // Oculta o formulário de cadastro
        });

        // Ao clicar no botão "Entrar" no formulário de login
        $("#btn-entrar").click(function(){
            // Lógica de validação
            var email = $("#email_login").val();
            var senha = $("#senha_login").val();

            // Verifica se os campos estão vazios
            if(email == "" || senha == "") {
                alert("Por favor, preencha todos os campos.");
                return;
            }

           
        });

        // Ao clicar no botão "Cadastrar"
        $("#btn-cadastrar").click(function(){
            // Envia uma requisição AJAX para cadastrar o cliente
            $.ajax({
                url: "CadastroServlet",
                type: "POST",
                data: $("#form-cadastro").serialize(),
                dataType: "json",
                success: function(data){
                    if(data.success){
                        // Exibe o alerta de sucesso
                        alert(data.message);
                        
                        // Exibe o alerta de cliente cadastrado com sucesso
                        alert("Cliente cadastrado com sucesso!");
                        
                        // Exibe o formulário de login
                        $("#login").show();
                        $("#cadastro").hide();
                    } else {
                        // Exibe o alerta de erro
                        alert(data.message);
                    }
                },
                error: function(xhr, status, error){
                    // Exibe o alerta de erro, se houver
                    alert("Erro ao cadastrar usuário: " + xhr.responseText);
                }
            });
        });
    });

    function openLoginForm() {
        $("#login").show();    // Exibe o formulário de login
        $("#cadastro").hide(); // Oculta o formulário de cadastro
    };
</script>
<script>
    // Captura o formulário de compra
    var formCompra = document.getElementById('formCompra');
    
    // Captura a mensagem de compra realizada
    var mensagemCompra = document.getElementById('mensagemCompra');
    
    // Adiciona um evento de submit ao formulário de compra
    formCompra.addEventListener('submit', function(event) {
        // Impede o comportamento padrão de submissão do formulário
        event.preventDefault();
        // Exibe a mensagem de compra realizada
        mensagemCompra.style.display = 'block';
        // Você pode adicionar aqui a lógica para enviar os dados do formulário para o backend
    });
</script>
<<script>
    // Função para mostrar o formulário de compra ao clicar no botão "Compre Agora"
    function mostrarFormularioCompra() {
        var formulario = document.getElementById("formularioCompra");
        formulario.style.display = "block";
    }

    // Função para enviar a compra (substitua este exemplo pela sua lógica de envio de compra)
    function enviarCompra() {
        // Aqui você pode adicionar sua lógica para enviar a compra para o backend
        // Por exemplo, você pode usar AJAX para enviar os dados do formulário para o servidor
        // e exibir a mensagem de sucesso após a resposta do servidor
        
        // Exibindo a mensagem de sucesso após um pequeno atraso (para simular uma resposta do servidor)
        var mensagemCompra = document.getElementById("mensagemCompra");
        mensagemCompra.style.display = "block";
        
        // Ocultando a mensagem e o formulário após 3 segundos
        setTimeout(function() {
            mensagemCompra.style.display = "none";
            document.getElementById("formularioCompra").style.display = "none";
        }, 3000); // Oculta a mensagem e o formulário após 3 segundos (3000 milissegundos)
        
        // Retornando false para evitar o envio padrão do formulário
        return false;
    }
</script>

</body>
</html>
