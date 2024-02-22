/* 06
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Serviço;
/**
 *
 * @author nalis
 */



import DAO.ClienteDAO;
import Modelo.Cliente;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    private final ClienteDAO clienteDAO;

    public ClienteServlet() {
        this.clienteDAO = new ClienteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implemente o código para lidar com requisições GET, se necessário
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Recuperando parâmetros do formulário
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Criando um objeto Cliente com os dados recebidos
        Cliente cliente = new Cliente(nome, email, senha);

        // Cadastrando o cliente
        clienteDAO.cadastrarCliente(cliente);

        
    }

    @Override
    public String getServletInfo() {
        return "Servlet para lidar com operações relacionadas a clientes";
    }
}
