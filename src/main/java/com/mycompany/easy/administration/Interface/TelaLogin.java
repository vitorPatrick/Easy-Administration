package com.mycompany.easy.administration.Interface;

import controller.Login;
import controller.Sessao; 
import com.mycompany.easy.administration.model.*; /*importa direto a pasta completa com asterísco*/
import javax.swing.*;
import java.awt.*; 

public class TelaLogin extends JFrame {
    private JTextField txtEmail = new JTextField(15);
    private JPasswordField txtSenha = new JPasswordField(15);
    private JButton btnEntrar = new JButton("Entrar");
    private Login servico = new Login();

    public TelaLogin() {
        setTitle("Sistema de Administração Jurídica");
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new JLabel("  Email:")); add(txtEmail);
        add(new JLabel("  Senha:")); add(txtSenha);
        add(new JLabel("")); add(btnEntrar);

        btnEntrar.addActionListener(e -> realizarLogin());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void realizarLogin() {
        String email = txtEmail.getText();
        String senha = new String(txtSenha.getPassword());

        Object usuario = servico.autenticar(email, senha);

        if (usuario != null) {
            // salva na sessão
            Sessao.usuarioLogado = usuario;
            
            // redireciona
            if (usuario instanceof Advogado) {
                new TelaAdvogado();
            } else if (usuario instanceof Cliente) {
                new TelaCliente();
            } else if (usuario instanceof Secretaria) {
                new TelaSecretaria();
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Email ou senha incorretos!");
        }
    }
}