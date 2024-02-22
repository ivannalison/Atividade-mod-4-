/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author nalis
 */
import Modelo.Passagem;
import Serviço.PassagemServico;
import java.util.List;

public class PassagemController {
    private final PassagemServico passagemService;

    public PassagemController() {
        this.passagemService = new PassagemServico();
    }

    // Método para cadastrar uma nova passagem
    public void cadastrarPassagem(Passagem passagem) {
        passagemService.cadastrarPassagem(passagem);
    }

    // Método para buscar uma passagem pelo ID
    public Passagem buscarPassagemPorId(int idPassagem) {
        return passagemService.buscarPassagemPorId(idPassagem);
    }

    // Método para buscar todas as passagens
    public List<Passagem> buscarTodasPassagens() {
        return passagemService.buscarTodasPassagens();
    }

    // Método para atualizar uma passagem
    public void atualizarPassagem(Passagem passagem) {
        passagemService.atualizarPassagem(passagem);
    }

    // Método para deletar uma passagem
    public void deletarPassagem(int idPassagem) {
        passagemService.deletarPassagem(idPassagem);
    }
}

