package com.mycompany.easy.administration;

import com.mycompany.easy.administration.model.*;
import controller.*;

public class EasyAdministration {
    public static void main(String[] args) {
        inicializarDados();
        AppCLI.main(args);
    }

    private static void inicializarDados() {
        new AdvogadoController().adicionarAdvogado(new Advogado("Vinicius", "Criminal", "000000/DF", "6199999", "vini@email.com", "123"));
        new SecretariaController().adicionarSecretaria(new Secretaria("Marta", "0918237", "Marta@gmail.com", "12341"));
        new ClienteController().adicionarCliente(new Cliente("Patrick", "12341", "Patrick@yahoo.com", "12345"));
        new ContratoController().adicionarContrato(new Contrato("001", 1, 1, 1500.00));
        System.out.println("--- Sistema carregado com sucesso ---");
    }
}