/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nalis
 */

import Modelo.Passagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassagemDAO {
    private final Conexao conexao;

    public PassagemDAO() {
        this.conexao = new Conexao();
    }

    // Método para cadastrar uma passagem
    public void cadastrarPassagem(Passagem passagem) {
        String sql = "INSERT INTO Passagem (destino, data_partida, preco) VALUES (?, ?, ?)";
        try (Connection con = conexao.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, passagem.getDestino());
            pstmt.setString(2, passagem.getDataPartida());
            pstmt.setDouble(3, passagem.getPreco());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar passagem: " + e.getMessage());
        }
    }

    // Método para buscar uma passagem pelo ID
    public Passagem buscarPassagemPorId(int idPassagem) {
        String sql = "SELECT * FROM Passagem WHERE id_passagem = ?";
        Passagem passagem = null;
        try (Connection con = conexao.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, idPassagem);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    passagem = new Passagem("Rio de Janeiro", "2024-02-20", 150.0);
                    passagem.setIdPassagem(rs.getInt("id_passagem"));
                    passagem.setDestino(rs.getString("destino"));
                    passagem.setDataPartida(rs.getString("data_partida"));
                    passagem.setPreco(rs.getDouble("preco"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar passagem por ID: " + e.getMessage());
        }
        return passagem;
    }

    // Método para buscar todas as passagens
    public List<Passagem> buscarTodasPassagens() {
        List<Passagem> passagens = new ArrayList<>();
        String sql = "SELECT * FROM Passagem";
        try (Connection con = conexao.conectar();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Passagem passagem = new Passagem("Rio de Janeiro", "2024-02-20", 150.0);
                passagem.setIdPassagem(rs.getInt("id_passagem"));
                passagem.setDestino(rs.getString("destino"));
                passagem.setDataPartida(rs.getString("data_partida"));
                passagem.setPreco(rs.getDouble("preco"));
                passagens.add(passagem);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todas as passagens: " + e.getMessage());
        }
        return passagens;
    }

    public void deletarPassagem(int idPassagem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void atualizarPassagem(Passagem passagem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

