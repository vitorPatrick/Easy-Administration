package com.mycompany.easy.administration.model;

import com.mycompany.easy.administration.App;

public class Secretaria extends Usuario {
    private int idSecretaria;
    private String cpf;

    public Secretaria(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public void exibirMenu() {
        // Polimorfismo: Direciona para o menu geral da Secretaria
        App.menuSecretaria();
    }

    // Getters e Setters específicos
    public int getIdSecretaria() { 
        return idSecretaria; 
    }
    public void setIdSecretaria(int id) { 
        this.idSecretaria = id; 
    }
    public String getCpf() { 
        return cpf; 
    }
    public void setCpf(String cpf) { 
        this.cpf = cpf; 
    }
}