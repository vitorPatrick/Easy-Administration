package com.mycompany.easy.administration.model;

public class Contrato {
    private int idContrato;
    private String numeroContrato;
    private int idCliente;
    private int idAdvogado;
    private double valorHonorarios;

    // Construtor compatível com: new Contrato("001", 1, 1, 1500.00)
    public Contrato(String numero, int idCliente, int idAdvogado, double valor) {
        this.numeroContrato = numero;
        this.idCliente = idCliente;
        this.idAdvogado = idAdvogado;
        this.valorHonorarios = valor;
    }

    // Getters e Setters
    public int getIdContrato() { return idContrato; }
    public void setIdContrato(int idContrato) { this.idContrato = idContrato; }
    public String getNumeroContrato() { return numeroContrato; }
    public int getIdCliente() { return idCliente; }
    public int getIdAdvogado() { return idAdvogado; }
    public double getValorHonorarios() { return valorHonorarios; }
}