package com.mycompany.easy.administration.model;
public class Secretaria {
    private String Nome;
    private int Id_Secretaria;
    private String CPF;
    private String Emial;
    private String Senha;
    
    public Secretaria(String Nome, String CPF,
                      String Email, String Senha){
        this.Nome = Nome;
        this.CPF = CPF;
        this.Emial = Email;
        this.Senha = Senha;
    }

    public String getNome() {
        return Nome;
    }

    public int getId_Secretaria() {
        return Id_Secretaria;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEmial() {
        return Emial;
    }

    public String getSenha() {
        return Senha;
    }
    
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setId_Secretaria(int Id_Secretaria) {
        this.Id_Secretaria = Id_Secretaria;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setEmial(String Emial) {
        this.Emial = Emial;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    } 
}
