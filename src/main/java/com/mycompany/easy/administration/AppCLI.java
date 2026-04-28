package com.mycompany.easy.administration;

import com.mycompany.easy.administration.model.*;
import controller.*;
import java.util.Scanner;
import java.util.List;

public class AppCLI {
    private static Scanner sc = new Scanner(System.in);
    private static Login login = new Login();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBEM-VINDO AO SISTEMA JURIDICO");
            System.out.println("1. Fazer Login");
            System.out.println("2. Encerrar Sistema");
            System.out.print("Escolha uma alternativa: ");
            String opcao = sc.nextLine();

            if (opcao.equals("1")) {
                fazerLogin();
            } else if (opcao.equals("2")) {
                System.out.println("Encerrando o sistema...");
                System.exit(0);
            } else {
                System.out.println("Opçao invalida!");
            }
        }
    }

    private static void fazerLogin() {
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Senha: "); String senha = sc.nextLine();

        Object user = login.autenticar(email, senha);
        if (user != null) {
            if (user instanceof Secretaria) menuSecretaria();
            else if (user instanceof Advogado) menuAdvogado((Advogado) user);
            else if (user instanceof Cliente) menuCliente((Cliente) user);
        } else {
            System.out.println("Credenciais invalidas!");
        }
    }

    private static void menuSecretaria() {
        while (true) {
            System.out.println("\n--- MENU SECRETARIA ---");
            System.out.println("1. Cadastrar Advogado\n2. Cadastrar Cliente\n3. Logout\n4. Sair");
            String op = sc.nextLine();
            if (op.equals("1")) {
                System.out.print("Nome: "); String nome = sc.nextLine();
                new AdvogadoController().adicionarAdvogado(new Advogado(nome, "Geral", "000", "000", "adv@email.com", "123"));
                System.out.println("Advogado cadastrado!");
            } else if (op.equals("2")) {
                System.out.print("Nome: "); String nome = sc.nextLine();
                new ClienteController().adicionarCliente(new Cliente(nome, "000", "cli@email.com", "123"));
                System.out.println("Cliente cadastrado!");
            } else if (op.equals("3")) return;
            else if (op.equals("4")) System.exit(0);
        }
    }

    private static void menuAdvogado(Advogado adv) {
        while (true) {
            System.out.println("\n--- PAINEL DO ADVOGADO: " + adv.getNome() + " ---");
            System.out.println("1. Ver meus Clientes\n2. Ver meus Contratos\n3. Logout\n4. Sair");
            String op = sc.nextLine();
            if (op.equals("1")) {
                List<Cliente> clientes = new AdvogadoController().buscarClientesDoAdvogado(adv.getIdAdvogado());
                for (Cliente c : clientes) System.out.println("Cliente: " + c.getNome());
            } else if (op.equals("2")) {
                for (Contrato c : BancoDeDados.contratos) {
                    if (c.getIdAdvogado() == adv.getIdAdvogado()) 
                        System.out.println("Contrato: " + c.getNumeroContrato() + " | R$" + c.getValorHonorarios());
                }
            } else if (op.equals("3")) return;
            else if (op.equals("4")) System.exit(0);
        }
    }

    private static void menuCliente(Cliente cli) {
        System.out.println("\n--- SEUS DADOS ---");
        System.out.println("Nome: " + cli.getNome() + " | Email: " + cli.getEmail());
        System.out.println("\n--- SEUS CONTRATOS ---");
        for (Contrato c : BancoDeDados.contratos) {
            if (c.getIdCliente() == cli.getIdCliente()) 
                System.out.println("Contrato: " + c.getNumeroContrato() + " | Valor: R$" + c.getValorHonorarios());
        }
        System.out.println("\n1. Logout | 2. Sair do Sistema");
        String op = sc.nextLine();
        if (op.equals("2")) System.exit(0);
    }
}