package com.mycompany.easy.administration.model;
public class Especialidade {
    private int Id_Especialidade;
    private String Nome_Especialidade;
    // método construtor
    public Especialidade(String Nome_Especialidade){
        this.Id_Especialidade = Id_Especialidade;
        this.Nome_Especialidade = Nome_Especialidade;
    }
    //gets e sets
    public int getId_Especialidade() {
        return Id_Especialidade;
    }

    public String getNome_Especialidade() {
        return Nome_Especialidade;
    }

    public void setId_Especialidade(int Id_Especialidade) {
        this.Id_Especialidade = Id_Especialidade;
    }

    public void setNome_Especialidade(String Nome_Especialidade) {
        this.Nome_Especialidade = Nome_Especialidade;
    }
}
