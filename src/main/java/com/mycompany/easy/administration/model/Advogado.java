package com.mycompany.easy.administration.model;

import com.mycompany.easy.administration.App;

public class Advogado extends Usuario {
    private int idAdvogado;
    private String especialidade;
    private String numeroOAB;
    private String telefone;

    public Advogado(String nome, String especialidade, String oab, String telefone, String email, String senha) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.numeroOAB = oab;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }
    // sobreescreve o que herda da classe pai (usuario)
    @Override
    public void exibirMenu() {
        // Polimorfismo: Direciona para o menu específico de Advogado
        App.menuAdvogado(this);
    }

    // gets e sets
    public int getIdAdvogado() { return idAdvogado; }
    public void setIdAdvogado(int idAdvogado) { this.idAdvogado = idAdvogado; }
    
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    
    public String getNumeroOAB() { return numeroOAB; }
    public void setNumeroOAB(String numeroOAB) { this.numeroOAB = numeroOAB; }
    
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}