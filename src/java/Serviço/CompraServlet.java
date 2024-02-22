/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviço;
/**
 *
 * @author nalis
 */



import DAO.CompraDAO;
import Modelo.Compra;
import Modelo.Passagem;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CompraServlet", urlPatterns = {"/CompraServlet"})
public class CompraServlet extends HttpServlet {

    private final CompraDAO compraDAO;

    // Inicializa o CompraDAO no construtor
    public CompraServlet() {
        this.compraDAO = new CompraDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém os dados do formulário
        String nomeCliente = request.getParameter("nome");
        int idPassagem = Integer.parseInt(request.getParameter("passagem"));
        int quantidadePassagem = Integer.parseInt(request.getParameter("quantidade"));
        String dataPartida = request.getParameter("data");

        // Obtém a passagem correspondente ao ID
        Passagem passagem = new PassagemServlet().buscarPassagemPorId(idPassagem);

        // Cria um objeto Compra com os dados fornecidos
        Compra compra = new Compra(nomeCliente, passagem, quantidadePassagem, dataPartida);

        // Realiza a compra utilizando o CompraDAO
        compraDAO.realizarCompra(compra);

        // Redireciona de volta para a página inicial após a compra
        response.sendRedirect("index.jsp");
    }

    // Método para buscar todas as compras
    public List<Compra> buscarTodasCompras() {
        return compraDAO.buscarTodasCompras();
    }

    // Método para buscar compras por ID do cliente
    public List<Compra> buscarComprasPorIdCliente(int idCliente) {
        return compraDAO.buscarComprasPorIdCliente(idCliente);
    }

    // Método para buscar compras por ID da passagem
    public List<Compra> buscarComprasPorIdPassagem(int idPassagem) {
        return compraDAO.buscarComprasPorIdPassagem(idPassagem);
    }
}
