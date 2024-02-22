/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
/**
 *
 * @author nalis
 */



import Modelo.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
    private final Conexao conexao;

    public CompraDAO() {
        this.conexao = new Conexao();
    } 

    // Método para buscar uma compra pelo ID do cliente
    public List<Compra> buscarComprasPorCliente(int idCliente) {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT * FROM Compra WHERE idCliente = ?";
        try (Connection con = conexao.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, idCliente);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    var compra = new Compra(rs.getString("nomeCliente"),
                                            rs.getInt("idPassagem"),
                                            rs.getInt("quantidade"),
                                            rs.getString("dataPartida"));
                    compra.setIdCompra(rs.getInt("idCompra"));
                    compra.setIdCliente(rs.getInt("idCliente"));
                    compras.add(compra);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar compras por cliente: " + e.getMessage());
        }
        return compras;
    }

    // Método para buscar compras por ID do cliente
    public List<Compra> buscarComprasPorIdCliente(int idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Manter este método
    }

    // Método para buscar todas as compras
    public List<Compra> buscarTodasCompras() {
        throw new UnsupportedOperationException("Not supported yet."); // Manter este método
    }

    // Método para realizar uma compra
    public void realizarCompra(Compra compra) {
        throw new UnsupportedOperationException("Not supported yet."); // Manter este método
    }

    // Método para buscar compras por ID da passagem
    public List<Compra> buscarComprasPorIdPassagem(int idPassagem) {
        throw new UnsupportedOperationException("Not supported yet."); // Manter este método
    }
}
