/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author nalis
 */

import Modelo.Compra;
import Serviço.CompraServico;
import java.util.List;

public class CompraController {
    private final CompraServico compraService;

    public CompraController() {
        this.compraService = new CompraServico();
    }

    // Método para realizar uma compra
    public void realizarCompra(Compra compra) {
        compraService.realizarCompra(compra);
    }

    // Método para buscar todas as compras
    public List<Compra> buscarTodasCompras() {
        return compraService.buscarTodasCompras();
    }

    // Método para buscar compras por ID do cliente
    public List<Compra> buscarComprasPorIdCliente(int idCliente) {
        return compraService.buscarComprasPorIdCliente(idCliente);
    }

    // Método para buscar compras por ID da passagem
    public List<Compra> buscarComprasPorIdPassagem(int idPassagem) {
        return compraService.buscarComprasPorIdPassagem(idPassagem);
    }
}

