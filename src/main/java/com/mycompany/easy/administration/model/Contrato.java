package com.mycompany.easy.administration.model;
 
public class Contrato {
    private int Id_Contrato;
    private String Numero_Contrato;
    private double Valor_Honorarios;
    private int Id_Cliente;
    private int Id_Advogado;
    private int Id_Especialidade;
 
    public Contrato(String Numero_Contrato, double Valor_Honorarios,
                    int Id_Cliente, int Id_Advogado, int Id_Especialidade) {
        this.Numero_Contrato = Numero_Contrato;
        this.Valor_Honorarios = Valor_Honorarios;
        this.Id_Cliente = Id_Cliente;
        this.Id_Advogado = Id_Advogado;
        this.Id_Especialidade = Id_Especialidade;
    }
 
    public int getId_Contrato() {
        return Id_Contrato;
    }
 
    public String getNumero_Contrato() {
        return Numero_Contrato;
    }
 
    public double getValor_Honorarios() {
        return Valor_Honorarios;
    }
 
    public int getId_Cliente() {
        return Id_Cliente;
    }
 
    public int getId_Advogado() {
        return Id_Advogado;
    }
 
    public int getId_Especialidade() {
        return Id_Especialidade;
    }
 
    public void setId_Contrato(int Id_Contrato) {
        this.Id_Contrato = Id_Contrato;
    }
 
    public void setNumero_Contrato(String Numero_Contrato) {
        this.Numero_Contrato = Numero_Contrato;
    }
 
    public void setValor_Honorarios(double Valor_Honorarios) {
        this.Valor_Honorarios = Valor_Honorarios;
    }
 
    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }
 
    public void setId_Advogado(int Id_Advogado) {
        this.Id_Advogado = Id_Advogado;
    }
 
    public void setId_Especialidade(int Id_Especialidade) {
        this.Id_Especialidade = Id_Especialidade;
    }
}