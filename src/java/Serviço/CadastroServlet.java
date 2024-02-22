/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviço;
// improt
/**
 *
 * @author nalis
 */



import DAO.ClienteDAO;
import Modelo.Cliente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastroServlet", urlPatterns = {"/CadastroServlet"})
public class CadastroServlet extends HttpServlet {
    
    
    
    
        // Método para inicialização do servlet
    @Override
    public void init() throws ServletException {
        // Registra o driver JDBC ao iniciar o servlet
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("Driver JDBC do MySQL não encontrado", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Recuperando parâmetros do formulário
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Verifica se o nome não está vazio antes de cadastrar
        if (nome != null && !nome.isEmpty()) {
            // Criando um objeto Cliente com os parâmetros obtidos
            Cliente cliente = new Cliente(nome, email, senha);
            
            // Chame o método do DAO para cadastrar o cliente
            ClienteDAO clienteDAO = new ClienteDAO();
            try {
                clienteDAO.cadastrarCliente(cliente);

                // Exibe o alerta de sucesso
                response.getWriter().println("<script>alert('Cliente cadastrado com sucesso!');</script>");
                // Redirecionando para o formulário de login
                response.getWriter().println("<script>location.href='index.jsp#login';</script>");
            } catch (IOException ex) {
                // Exibe o alerta de erro se ocorrer uma exceção
                response.getWriter().println("<script>alert('Erro ao cadastrar cliente. Por favor, tente novamente mais tarde.');</script>");
                Logger.getLogger(CadastroServlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Fechando a conexão com o banco de dados
                clienteDAO.fecharConexao();
            }
        } else {
            // Exibe o alerta de erro se o nome estiver vazio
            response.getWriter().println("<script>alert('Por favor, informe o nome do cliente!');</script>");
            // Redirecionando para a página inicial
            response.getWriter().println("<script>location.href='index.jsp';</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para processar cadastro de usuários";
    }
}