package com.mycompany.easy.administration;

import com.mycompany.easy.administration.model.*;
import controller.*;
import java.util.Scanner;
import java.util.List;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static Login login = new Login();
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBEM-VINDO AO SISTEMA JURIDICO");
            System.out.println("1. Fazer Login");
            System.out.println("2. Encerrar Sistema");
            System.out.print("Escolha uma alternativa: ");
            String opcao = sc.nextLine();
    // opções disponíveis no menu inicial
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
    // menu que aparece ao clicar a opçao 1 no menu inicial
    private static void fazerLogin() {
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Senha: "); String senha = sc.nextLine();
    // autenticador
        Object user = login.autenticar(email, senha);
        if (user != null) {
    // polimorfismo para chamar sua respectiva classe, se for secretaria vai chamar secretaria e assim por diante. 
            if (user instanceof Secretaria) menuSecretaria();
            else if (user instanceof Advogado) menuAdvogado((Advogado) user);
            else if (user instanceof Cliente) menuCliente((Cliente) user);
        } else {
            System.out.println("Credenciais invalidas!");
        }
    }
    // menu da secretaria completo
    private static void menuSecretaria() {
        while (true) {
            System.out.println("\nMENU SECRETARIA");
            System.out.println("1. Cadastrar Advogado\n2. Cadastrar Cliente\n3. Logout\n4. Sair");
            String op = sc.nextLine();
    // cadastramento de advogado
            if (op.equals("1")) {
                System.out.print("Nome: "); String nome = sc.nextLine();
                new AdvogadoController().adicionarAdvogado(new Advogado(nome, "Geral", "000", "000", "adv@email.com", "123"));
                System.out.println("Advogado cadastrado!");
    // cadastramento de cliente
            } else if (op.equals("2")) {
                System.out.print("Nome: "); String nome = sc.nextLine();
                new ClienteController().adicionarCliente(new Cliente(nome, "000", "cli@email.com", "123"));
                System.out.println("Cliente cadastrado!");
    // retorna para o menu
            } else if (op.equals("3")) return;
            // fecha o programa
            else if (op.equals("4")) System.exit(0);
        }
    }

    private static void menuAdvogado(Advogado adv) {
        while (true) {
            System.out.println("\nPAINEL DO ADVOGADO: " + adv.getNome() + "");
    // opções ao logar como advogado
            System.out.println("1. Ver meus Clientes\n2. Ver meus Contratos\n3. Logout\n4. Sair");
            String op = sc.nextLine();
    // dá informações do cliente
            if (op.equals("1")) {
                List<Cliente> clientes = new AdvogadoController().buscarClientesDoAdvogado(adv.getIdAdvogado());
                for (Cliente c : clientes) System.out.println("Cliente: " + c.getNome());
    // da informações dos contratos
            } else if (op.equals("2")) {
                for (Contrato c : BancoDeDados.contratos) {
                    if (c.getIdAdvogado() == adv.getIdAdvogado()) 
                        System.out.println("Contrato: " + c.getNumeroContrato() + " | R$" + c.getValorHonorarios());
                }
    // volta ao menu
            } else if (op.equals("3")) return;
    // fecha o sistema
            else if (op.equals("4")) System.exit(0);
        }
    }
    // menu do cliente completo 
    private static void menuCliente(Cliente cli) {
        System.out.println("\n SEUS DADOS");
        System.out.println("Nome: " + cli.getNome() + " | Email: " + cli.getEmail());
        System.out.println("\nSEUS CONTRATOS");
    // ao acessar como cliente já aparece direto essas informações
        for (Contrato c : BancoDeDados.contratos) {
            if (c.getIdCliente() == cli.getIdCliente()) 
                System.out.println("Contrato: " + c.getNumeroContrato() + " | Valor: R$" + c.getValorHonorarios());
        }
    // retorna as duas opções padrões
        System.out.println("\n1. Logout | 2. Sair do Sistema");
        String op = sc.nextLine();
    // fecha o programa
        if (op.equals("2")) System.exit(0);
    }
}