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
import java.util.List;

public class PassagemServico {
    private final PassagemDAO passagemDAO;

    public PassagemServico() {
        this.passagemDAO = new PassagemDAO();
    }

    // Método para cadastrar uma nova passagem
    public void cadastrarPassagem(Passagem passagem) {
        passagemDAO.cadastrarPassagem(passagem);
    }

    // Método para buscar uma passagem pelo ID
    public Passagem buscarPassagemPorId(int idPassagem) {
        return passagemDAO.buscarPassagemPorId(idPassagem);
    }

    // Método para buscar todas as passagens
    public List<Passagem> buscarTodasPassagens() {
        return passagemDAO.buscarTodasPassagens();
    }

    // Método para atualizar uma passagem
    public void atualizarPassagem(Passagem passagem) {
        passagemDAO.atualizarPassagem(passagem);
    }

    // Método para deletar uma passagem
    public void deletarPassagem(int idPassagem) {
        passagemDAO.deletarPassagem(idPassagem);
    }
}

