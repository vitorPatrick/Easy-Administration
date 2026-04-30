package com.mycompany.easy.administration.model;

/**
 * Classe base abstrata para aplicar Polimorfismo.
 */
public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;

    // Método abstrato: cada subclasse decide como exibir seu próprio menu
    public abstract void exibirMenu();

    // Getters e Setters comuns
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}