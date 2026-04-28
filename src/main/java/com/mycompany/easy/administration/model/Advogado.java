package com.mycompany.easy.administration.model;

public class Advogado {
    private int idAdvogado;
    private String nome;
    private String especialidade;
    private String numeroOAB;
    private String telefone;
    private String email;
    private String senha;

    // Construtor completo (compatível com a chamada no AppCLI)
    public Advogado(String nome, String especialidade, String oab, String telefone, String email, String senha) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.numeroOAB = oab;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters
    public int getIdAdvogado() {
        return idAdvogado;
    }

    public void setIdAdvogado(int idAdvogado) {
        this.idAdvogado = idAdvogado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNumeroOAB() {
        return numeroOAB;
    }

    public void setNumeroOAB(String numeroOAB) {
        this.numeroOAB = numeroOAB;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}