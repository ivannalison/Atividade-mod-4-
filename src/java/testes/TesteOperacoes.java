/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;
/**
 *
 * @author nalis
 */



import Modelo.Cliente;
import Modelo.Compra;
import Modelo.Passagem;
import Serviço.ClienteServico;
import Serviço.CompraServico;
import Serviço.PassagemServico;
import java.sql.Date;

public class TesteOperacoes {
    public static void main(String[] args) {
        ClienteServico clienteServico = new ClienteServico();
        PassagemServico passagemServico = new PassagemServico();
        CompraServico compraServico = new CompraServico();

        // Teste de cadastro de cliente
        Cliente cliente = new Cliente("João", "joao@example.com", "123456");
        clienteServico.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso");

        // Teste de cadastro de passagem
        Passagem passagem = new Passagem("Rio de Janeiro", "2024-02-20", 150.0);
        passagemServico.cadastrarPassagem(passagem);
        System.out.println("Passagem cadastrada com sucesso");

        // Teste de realização de compra
        Date dataAtual = new Date(System.currentTimeMillis());
        Compra compra = new Compra(cliente.getId(), passagem.getId(), 1, dataAtual);
        compraServico.realizarCompra(compra);
        System.out.println("Compra realizada com sucesso");
    }
}
