package com.mycompany.easy.administration.model;

public class Cliente {
    private String nome;
    private int idCliente;
    private String cpf;
    private String email;
    private String senha;
// método construtor
    public Cliente(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }
// gets e sets
    public String getNome() { return nome; }
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int id) { this.idCliente = id; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
}