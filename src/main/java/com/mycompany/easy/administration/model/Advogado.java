package com.mycompany.easy.administration.model;
public class Advogado {
    private String Nome;
    private int Id_Advogado;
    private String Especialidade;
    private String NumeroOAB;
    private String Telefone;
    private String Email;
    private String Senha;
    
    public Advogado(String Nome, String Especialidade,
                    String NumeroOAB, String Telefone, String Email, String Senha){
        this.Nome = Nome;
        this.Especialidade = Especialidade;
        this.NumeroOAB = NumeroOAB;
        this.Telefone = Telefone;
        this.Email = Email;
        this.Senha = Senha;
    }

    public String getNome() {
        return Nome;
    }

    public int getId_Advogado() {
        return Id_Advogado;
    }

    public String getEspecialidade() {
        return Especialidade;
    }

    public String getNumeroOAB() {
        return NumeroOAB;
    }

    public String getTelefone() {
        return Telefone;
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
    
    public void setId_Advogado(int Id_Advogado){
        this.Id_Advogado = Id_Advogado;
    }

    public void setEspecialidade(String Especialidade) {
        this.Especialidade = Especialidade;
    }

    public void setNumeroOAB(String NumeroOAB) {
        this.NumeroOAB = NumeroOAB;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
}
