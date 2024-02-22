/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviço;

/**
 *
 * @author nalis
 */


import DAO.ClienteDAO;
import Modelo.Cliente;
import java.util.List;

public class ClienteServico {
    private final ClienteDAO clienteDAO;

    public ClienteServico() {
        this.clienteDAO = new ClienteDAO();
    }

    // Método para cadastrar um novo cliente
    public void cadastrarCliente(Cliente cliente) {
        clienteDAO.cadastrarCliente(cliente);
    }

    // Método para buscar um cliente pelo ID
    public Cliente buscarClientePorId(int idCliente) {
        return clienteDAO.buscarClientePorId(idCliente);
    }

    // Método para buscar todos os clientes
    public List<Cliente> buscarTodosClientes() {
        return clienteDAO.buscarTodosClientes();
    }

    // Método para atualizar um cliente
    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizarCliente(cliente);
    }

    // Método para deletar um cliente
    public void deletarCliente(int idCliente) {
        clienteDAO.deletarCliente(idCliente);
    }
}

