package com.mycompany.easy.administration.model;

public class Secretaria {
    private String nome;
    private int idSecretaria;
    private String cpf;
    private String email;
    private String senha;
    // método construtor
    public Secretaria(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
    //gets e sets
    public String getNome() { return nome; }
    public int getIdSecretaria() { return idSecretaria; }
    public void setIdSecretaria(int id) { this.idSecretaria = id; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public String getCpf() { return cpf; }
}