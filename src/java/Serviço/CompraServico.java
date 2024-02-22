/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviço;

/**
 *
 * @author nalis
 */



import DAO.CompraDAO;
import Modelo.Compra;
import java.util.List;

public class CompraServico {
    private final CompraDAO compraDAO;

    public CompraServico() {
        this.compraDAO = new CompraDAO();
    }

    // Método para realizar uma compra
    public void realizarCompra(Compra compra) {
        compraDAO.realizarCompra(compra);
    }

    // Método para buscar todas as compras
    public List<Compra> buscarTodasCompras() {
        return compraDAO.buscarTodasCompras();
    }

    // Método para buscar compras por ID do cliente
    public List<Compra> buscarComprasPorIdCliente(int idCliente) {
        return compraDAO.buscarComprasPorIdCliente(idCliente);
    }

    // Método para buscar compras por ID da passagem
    public List<Compra> buscarComprasPorIdPassagem(int idPassagem) {
        return compraDAO.buscarComprasPorIdPassagem(idPassagem);
    }
}

