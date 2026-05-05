package com.mycompany.easy.administration.model;

// abstract para aplicar o polimorfismo
public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;

    // abstract pois cada classe exibe o menu da sua propria forma
    public abstract void exibirMenu();

    // gets e sets
    public String getNome() { 
        return nome; 
    }
    public void setNome(String nome) { 
        this.nome = nome; 
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