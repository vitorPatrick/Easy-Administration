package com.mycompany.easy.administration.model;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    // armazenar entidades
    public static List<Contrato> contratos = new ArrayList<>();
    public static List<Advogado> advogados = new ArrayList<>();
    public static List<Cliente> clientes = new ArrayList<>();
    public static List<Secretaria> secretarias = new ArrayList<>();
    public static List<Especialidade> especialidades = new ArrayList<>();
    // gerenciador de ID
    public static int countAdv = 1, countCli = 1, countSec = 1, countCon = 1, countEsp = 1;
}