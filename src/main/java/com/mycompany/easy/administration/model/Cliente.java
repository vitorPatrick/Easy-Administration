package com.mycompany.easy.administration.model;

import com.mycompany.easy.administration.App;

public class Cliente extends Usuario {
    private int idCliente;
    private String cpf;

    public Cliente(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public void exibirMenu() {
        // Polimorfismo: Direciona para o menu específico de Cliente
        App.menuCliente(this);
    }

    // Getters e Setters específicos
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int id) { this.idCliente = id; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}