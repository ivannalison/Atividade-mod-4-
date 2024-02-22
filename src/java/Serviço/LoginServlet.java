/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviço;
/**
 *
 * @author nalis
 */



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        // Recuperando parâmetros do formulário
        String email = request.getParameter("email_login");
        String senha = request.getParameter("senha_login");

        // Realizando a conexão com o banco de dados
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agencia", "root", "")) {
            // Verificando se o usuário e senha estão corretos
            String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                stmt.setString(2, senha);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    // Exibindo mensagem de sucesso com alerta jQuery
                    out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
                    out.println("<script>");
                    out.println("$(document).ready(function(){");
                    out.println("alert('Login realizado com sucesso!');");
                    out.println("window.location.href = 'index.jsp';");
                    out.println("});");
                    out.println("</script>");
                } else {
                    // Exibindo mensagem de erro se o usuário/senha estiver incorreto
                    response.sendRedirect("index.jsp");
                }
            }
        } catch (SQLException e) {
            // Exibindo mensagem de erro
            response.sendRedirect("index.jsp");
        } finally {
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para processar login de usuários";
    }
}
