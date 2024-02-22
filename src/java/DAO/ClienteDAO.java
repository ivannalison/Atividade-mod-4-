/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package DAO;
/**
 *
 * @author nalis
 */



import Modelo.Cliente;
import Modelo.Compra;
import jakarta.servlet.ServletException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private final Conexao conexao;

    public ClienteDAO() {
        this.conexao = new Conexao();
    }

    public ClienteDAO(Conexao conexao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       
    public void init() throws ServletException {
        // Registra o driver JDBC ao iniciar o servlet
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException("Driver JDBC do MySQL não encontrado", e);
        }
    }

    // Método para cadastrar um novo cliente
    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nome, email, senha) VALUES (?, ?, ?)";
        try (Connection con = conexao.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getSenha());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    // Método para buscar um cliente pelo ID
    public Cliente buscarClientePorId(int idCliente) {
        String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
        Cliente cliente = null;
        try (Connection con = conexao.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, idCliente);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("id_cliente"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setSenha(rs.getString("senha"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente por ID: " + e.getMessage());
        }
        return cliente;
    }

    // Método para buscar todos os clientes
    public List<Cliente> buscarTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection con = conexao.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os clientes: " + e.getMessage());
        }
        return clientes;
    }

    // Método para atualizar um cliente
    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ?, email = ?, senha = ? WHERE id_cliente = ?";
        try (Connection con = conexao.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getSenha());
            pstmt.setInt(4, cliente.getIdCliente());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    // Método para deletar um cliente
    public void deletarCliente(int idCliente) {
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        try (Connection con = conexao.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, idCliente);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
        }
    }

    // Método para gerar uma compra para o cliente
    public void gerarCompra(Cliente cliente, Compra compra) {
        // Lógica para gerar a compra para o cliente
        System.out.println("Compra gerada para o cliente: " + cliente.getNome());
        
        String sql = "INSERT INTO Compra (id_cliente, id_passagem, quantidade, data_compra) VALUES (?, ?, ?, ?)";
        try (Connection con = conexao.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, cliente.getIdCliente());
            pstmt.setInt(2, compra.getIdPassagem());
            pstmt.setInt(3, compra.getQuantidade());
            pstmt.setDate(4, compra.getDataCompra());
            pstmt.executeUpdate();

            System.out.println("Compra registrada no banco de dados.");

        } catch (SQLException e) {
            System.out.println("Erro ao gerar compra: " + e.getMessage());
        }
    }

    public void fecharConexao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
