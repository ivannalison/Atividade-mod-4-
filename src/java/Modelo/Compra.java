/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author nalis
 */





import java.sql.Date;

public class Compra {
    private int idCliente;
    private int idPassagem;
    private int quantidade;
    private Date dataCompra;

    // Construtor vazio
    public Compra(String nomeCliente, Passagem passagem, int quantidadePassagem, String dataPartida) {
    }

    // Construtor com todos os atributos
    public Compra(int idCliente, int idPassagem, int quantidade, Date dataCompra) {
        this.idCliente = idCliente;
        this.idPassagem = idPassagem;
        this.quantidade = quantidade;
        this.dataCompra = dataCompra;
    }

    public Compra(String Cliente, Passagem passagem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Compra(String string, int aInt, int aInt0, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters e setters para todos os atributos
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(int idPassagem) {
        this.idPassagem = idPassagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    // Método para realizar a compra
    public void realizarCompra() {
        // Lógica para realizar a compra
        System.out.println("Compra realizada para o cliente: " + idCliente);
    }

    // Método toString para representação textual do objeto
    @Override
    public String toString() {
        return "Compra{" +
                "idCliente=" + idCliente +
                ", idPassagem=" + idPassagem +
                ", quantidade=" + quantidade +
                ", dataCompra=" + dataCompra +
                '}';
    }

    public void setIdCompra(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
