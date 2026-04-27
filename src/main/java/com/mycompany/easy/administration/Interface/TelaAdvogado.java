package com.mycompany.easy.administration.Interface;

import controller.Sessao;
import controller.ContratoController; 
import com.mycompany.easy.administration.model.Advogado;
import com.mycompany.easy.administration.model.Contrato;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaAdvogado extends JFrame {
    
    public TelaAdvogado() {
        Advogado a = (Advogado) Sessao.usuarioLogado;
        setTitle("Painel do Advogado: " + a.getNome());
        setSize(450, 400);
        setLayout(new GridLayout(6, 1, 10, 10));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // 1. exibir dados básicos
        add(new JLabel("Bem-vindo, Dr(a). " + a.getNome(), SwingConstants.CENTER));
        add(new JLabel("Especialidade: " + a.getEspecialidade(), SwingConstants.CENTER));
        
        // 2. botão para contar contratos
        JButton btnContratos = new JButton("Ver Meus Contratos");
        btnContratos.addActionListener(e -> exibirContagemContratos(a.getId_Advogado()));
        add(btnContratos);

        add(new JButton("Minhas Especialidades"));
        
        // 3. botão Sair com funcionalidade completa
        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(e -> System.exit(0)); // Encerra o programa
        add(btnSair);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // método que auxilia para busca e mostragem da quantidade de contratos
    private void exibirContagemContratos(int idAdvogado) {
        ContratoController cc = new ContratoController();
        List<Contrato> todos = cc.listarTodosContratos();
        int contagem = 0;
        
        for (Contrato c : todos) {
            if (c.getId_Advogado() == idAdvogado) {
                contagem++;
            }
        }
        
        JOptionPane.showMessageDialog(this, "Você possui " + contagem + " contrato(s) sob sua responsabilidade.");
    }
}