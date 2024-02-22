/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


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
