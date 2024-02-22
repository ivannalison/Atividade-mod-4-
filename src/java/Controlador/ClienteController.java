/* 01
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author nalis
 */




import Modelo.Cliente;
import Serviço.ClienteServico;
import java.util.List;

public class ClienteController {
    private final ClienteServico clienteServlet;

    public ClienteController() {
        this.clienteServlet = new ClienteServico();
    }

    // Método para cadastrar um novo cliente
    public void cadastrarCliente(Cliente cliente) {
        clienteServlet.cadastrarCliente(cliente);
    }

    // Método para buscar um cliente pelo ID
    public Cliente buscarClientePorId(int idCliente) {
        return clienteServlet.buscarClientePorId(idCliente);
    }

    // Método para buscar todos os clientes
    public List<Cliente> buscarTodosClientes() {
        return clienteServlet.buscarTodosClientes();
    }

    // Método para atualizar um cliente
    public void atualizarCliente(Cliente cliente) {
      clienteServlet.atualizarCliente(cliente);
    }

    // Método para deletar um cliente
    public void deletarCliente(int idCliente) {
       clienteServlet.deletarCliente(idCliente);
    }
}

