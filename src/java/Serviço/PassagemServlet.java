/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviço;
/**
 *
 * @author nalis
 */



import DAO.PassagemDAO;
import Modelo.Passagem;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PassagemServlet", urlPatterns = {"/PassagemServlet"})
public class PassagemServlet extends HttpServlet {

    private final PassagemDAO passagemDAO;

    public PassagemServlet() {
        this.passagemDAO = new PassagemDAO();
    }

    // Método para buscar todas as passagens
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Passagem> passagens = passagemDAO.buscarTodasPassagens();
        request.setAttribute("passagens", passagens);
        request.getRequestDispatcher("form_compra.jsp").forward(request, response);
    }

    // Método para cadastrar uma nova passagem
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupere os parâmetros do formulário
        String origem = request.getParameter("origem");
        String destino = request.getParameter("destino");
        double preco = Double.parseDouble(request.getParameter("preco"));
        
        // Crie um objeto Passagem com os parâmetros fornecidos
        Passagem passagem = new Passagem(origem, destino, preco);
        
        // Chame o método para cadastrar a passagem
        passagemDAO.cadastrarPassagem(passagem);
        
        // Redirecione de volta ao formulário de compra
        response.sendRedirect("form_compra.jsp");
    }

    // Método para buscar uma passagem pelo ID
    protected void buscarPassagemPorId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lógica para buscar uma passagem por ID
        int idPassagem = Integer.parseInt(request.getParameter("idPassagem"));
        Passagem passagem = passagemDAO.buscarPassagemPorId(idPassagem);
        
        // Você pode manipular a passagem conforme necessário, como enviar como resposta JSON
    }

    // Método para atualizar uma passagem
    protected void atualizarPassagem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lógica para atualizar uma passagem
        // Recupere os parâmetros do formulário ou da requisição
        int idPassagem = Integer.parseInt(request.getParameter("idPassagem"));
        String origem = request.getParameter("origem");
        String destino = request.getParameter("destino");
        double preco = Double.parseDouble(request.getParameter("preco"));
        
        // Crie um objeto Passagem com os parâmetros fornecidos
        Passagem passagem = new Passagem(idPassagem, origem, destino, preco);
        
        // Chame o método para atualizar a passagem
        passagemDAO.atualizarPassagem(passagem);
        
        // Redirecione ou envie uma resposta conforme necessário
    }

    // Método para deletar uma passagem
    protected void deletarPassagem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lógica para deletar uma passagem
        int idPassagem = Integer.parseInt(request.getParameter("idPassagem"));
        passagemDAO.deletarPassagem(idPassagem);
        
        // Redirecione ou envie uma resposta conforme necessário
    }

    Passagem buscarPassagemPorId(int idPassagem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
