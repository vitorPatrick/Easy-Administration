package com.mycompany.easy.administration.model;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    /*lista estática acessível de qualquer classe*/ 
    public static List<Advogado> advogados = new ArrayList<>();
    public static List<Cliente> clientes = new ArrayList<>();
    public static List<Secretaria> secretarias = new ArrayList<>();
    public static List<Especialidade> especialidades = new ArrayList<>();
    public static List<Contrato> contratos = new ArrayList<>();
}
