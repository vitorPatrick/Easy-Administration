package com.mycompany.easy.administration.model;
public class Cliente {
    private String Nome;
    private int Id_Cliente;
    private String CPF;
    private String Email;
    private String Senha;
    
    public Cliente(String Nome, String CPF, String Email, String Senha){
        this.Nome = Nome;
        this.CPF = CPF;
        this.Email = Email;
        this.Senha = Senha;
    }

    public String getNome() {
        return Nome;
    }

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEmail() {
        return Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
}
