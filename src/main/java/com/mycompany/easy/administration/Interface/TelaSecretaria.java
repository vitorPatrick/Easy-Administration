package com.mycompany.easy.administration.Interface;

import controller.*;
import com.mycompany.easy.administration.model.*;
import javax.swing.*;
import java.awt.*;
// painel de entrada para tela inicial do login para secretaria
public class TelaSecretaria extends JFrame {
    public TelaSecretaria() {
        Secretaria s = (Secretaria) Sessao.usuarioLogado;
        setTitle("Painel da Secretaria: " + s.getNome());
        setSize(400, 300);
        setLayout(new GridLayout(4, 1, 10, 10));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        add(new JLabel("Bem-vinda, " + s.getNome(), SwingConstants.CENTER));
        // botao de cadastro de novo advogado
        JButton btnAdv = new JButton("Cadastrar Novo Advogado");
        btnAdv.addActionListener(e -> cadastrarAdvogado());
        add(btnAdv);
        // botao de cadastro de novo cliente
        JButton btnCli = new JButton("Cadastrar Novo Cliente");
        btnCli.addActionListener(e -> cadastrarCliente());
        add(btnCli);
        // botao de sair
        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(e -> System.exit(0));
        add(btnSair);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cadastrarAdvogado() {
        // criando campos de entrada de dados do advogado
        JTextField nome = new JTextField();
        JTextField esp = new JTextField();
        JTextField oab = new JTextField();
        JTextField email = new JTextField();
        JTextField senha = new JPasswordField();

        Object[] msg = {"Nome:", nome, "Especialidade:", esp, "OAB:", oab, "Email:", email, "Senha:", senha};
        int res = JOptionPane.showConfirmDialog(null, msg, "Novo Advogado", JOptionPane.OK_CANCEL_OPTION);

        if (res == JOptionPane.OK_OPTION) {
            Advogado novo = new Advogado(nome.getText(), esp.getText(), oab.getText(), "0000", email.getText(), senha.getText());
            new AdvogadoController().adicionarAdvogado(novo);
            JOptionPane.showMessageDialog(this, "Advogado cadastrado com sucesso!");
        }
    }
// criando campo de entrada de dados do cliente
    private void cadastrarCliente() {
        JTextField nome = new JTextField();
        JTextField cpf = new JTextField();
        JTextField email = new JTextField();
        JTextField senha = new JPasswordField();

        Object[] msg = {"Nome:", nome, "CPF:", cpf, "Email:", email, "Senha:", senha};
        int res = JOptionPane.showConfirmDialog(null, msg, "Novo Cliente", JOptionPane.OK_CANCEL_OPTION);

        if (res == JOptionPane.OK_OPTION) {
            Cliente novo = new Cliente(nome.getText(), cpf.getText(), email.getText(), senha.getText());
            new ClienteController().adicionarCliente(novo);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
        }
    }
}