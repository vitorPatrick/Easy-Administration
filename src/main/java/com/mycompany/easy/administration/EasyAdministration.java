package com.mycompany.easy.administration;

import com.mycompany.easy.administration.model.*;
import controller.*;
    // puxa a classe app e inicializa ela por aqui
public class EasyAdministration {
    public static void main(String[] args) {
        inicializarDados();
        App.main(args);
    }
    // na classe app chamarão esses dados
    private static void inicializarDados() {
        new AdvogadoController().adicionarAdvogado(new Advogado("Vinicius", "Criminal", "000000/DF", "6199999", "vini@email.com", "123"));
        new SecretariaController().adicionarSecretaria(new Secretaria("Marta", "0918237", "Marta@gmail.com", "12341"));
        new ClienteController().adicionarCliente(new Cliente("Patrick", "12341", "Patrick@yahoo.com", "12345"));
        new ContratoController().adicionarContrato(new Contrato("001", 1, 1, 1500.00));
        System.out.println("--- Sistema carregado com sucesso ---");
    }
}