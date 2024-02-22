/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * author nalis
 */

public class Passagem {
    private int idPassagem;
    private String destino;
    private String dataPartida;
    private double preco;

    // Construtor vazio
    public Passagem(String rio_de_Janeiro, String string, double par) {
    }

    // Construtor com todos os atributos
    public Passagem(int idPassagem, String destino, String dataPartida, double preco) {
        this.idPassagem = idPassagem;
        this.destino = destino;
        this.dataPartida = dataPartida;
        this.preco = preco;
    }

    public Passagem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters e setters para todos os atributos
    public int getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(int idPassagem) {
        this.idPassagem = idPassagem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método para comprar uma passagem
    public void comprar() {
        // Lógica para comprar uma passagem
        System.out.println("Passagem comprada para o destino: " + destino);
    }

    // Método toString para representação textual do objeto
    @Override
    public String toString() {
        return "Passagem{" +
                "idPassagem=" + idPassagem +
                ", destino='" + destino + '\'' +
                ", dataPartida='" + dataPartida + '\'' +
                ", preco=" + preco +
                '}';
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
