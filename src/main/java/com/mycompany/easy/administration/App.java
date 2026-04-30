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

        Usuario user = login.autenticar(email, senha);

        if (user != null) {
            //menu da classe especifica identificada
            user.exibirMenu();
        } else {
            System.out.println("Credenciais invalidas!");
        }
    }

    // menu da secretaria
    public static void menuSecretaria() {
        while (true) {
            System.out.println("\nMENU SECRETARIA");
            System.out.println("1. Cadastrar Advogado\n2. Cadastrar Cliente\n3. Listar Todos\n4. Logout\n5. Sair");
            String op = sc.nextLine();

            if (op.equals("1")) {
                System.out.print("Nome: "); String nome = sc.nextLine();
                System.out.print("Especialidade: "); String esp = sc.nextLine();
                System.out.print("OAB: "); String oab = sc.nextLine();
                System.out.print("Telefone: "); String tel = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Senha: "); String senha = sc.nextLine();

                Advogado novoAdv = new Advogado(nome, esp, oab, tel, email, senha);
                novoAdv.setIdAdvogado(BancoDeDados.countAdv++);
                new AdvogadoController().adicionarAdvogado(novoAdv);
                System.out.println("Advogado cadastrado!");

            } else if (op.equals("2")) {
                System.out.print("Nome: "); String nome = sc.nextLine();
                System.out.print("CPF: "); String cpf = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Senha: "); String senha = sc.nextLine();

                Cliente novoCli = new Cliente(nome, cpf, email, senha);
                novoCli.setIdCliente(BancoDeDados.countCli++);
                new ClienteController().adicionarCliente(novoCli);
                System.out.println("Cliente cadastrado!");

            } else if (op.equals("3")) {
                System.out.println("\nLISTA DE ADVOGADOS");
                for (Advogado a : BancoDeDados.advogados) {
                    System.out.println("ID: " + a.getIdAdvogado() + " | Nome: " + a.getNome() + " | OAB: " + a.getNumeroOAB());
                }
                System.out.println("\nLISTA DE CLIENTES");
                for (Cliente c : BancoDeDados.clientes) {
                    System.out.println("ID: " + c.getIdCliente() + " | Nome: " + c.getNome() + " | Email: " + c.getEmail());
                }
            } else if (op.equals("4")) {
                return; 
            } else if (op.equals("5")) {
                System.exit(0);
            }
        }
    }

    // menu do advogado
    public static void menuAdvogado(Advogado adv) {
        while (true) {
            System.out.println("\nPAINEL DO ADVOGADO: " + adv.getNome());
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
            } else if (op.equals("3")) {
                return;
            } else if (op.equals("4")) {
                System.exit(0);
            }
        }
    }

    // menu do cliente
    public static void menuCliente(Cliente cli) {
        while (true) {
            System.out.println("\n SEUS DADOS");
            System.out.println("Nome: " + cli.getNome() + " | Email: " + cli.getEmail());
            System.out.println("\nSEUS CONTRATOS");
            for (Contrato c : BancoDeDados.contratos) {
                if (c.getIdCliente() == cli.getIdCliente()) 
                    System.out.println("Contrato: " + c.getNumeroContrato() + " | Valor: R$" + c.getValorHonorarios());
            }
            System.out.println("\n1. Logout | 2. Sair do Sistema");
            String op = sc.nextLine();
            
            if (op.equals("1")) return;
            else if (op.equals("2")) System.exit(0);
        }
    }
}