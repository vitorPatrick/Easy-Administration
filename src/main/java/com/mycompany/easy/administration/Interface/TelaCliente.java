package com.mycompany.easy.administration.Interface;

import controller.Sessao;
import controller.ContratoController;
import com.mycompany.easy.administration.model.Cliente;
import com.mycompany.easy.administration.model.Contrato;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCliente extends JFrame {
    
    public TelaCliente() {
        Cliente c = (Cliente) Sessao.usuarioLogado;
        setTitle("Painel do Cliente: " + c.getNome());
        setSize(400, 300);
        setLayout(new GridLayout(4, 1, 10, 10));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        add(new JLabel("Olá, " + c.getNome(), SwingConstants.CENTER));
        
        // 1. botão que consulta contratos
        JButton btnContratos = new JButton("Consultar Meus Contratos");
        btnContratos.addActionListener(e -> listarMeusContratos(c.getId_Cliente()));
        add(btnContratos);
        
        // 2. botão que altera dados
        JButton btnAlterar = new JButton("Alterar Meus Dados");
        btnAlterar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade em desenvolvimento!"));
        add(btnAlterar);
        
        // 3. botão de sair
        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(e -> System.exit(0));
        add(btnSair);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void listarMeusContratos(int idCliente) {
        ContratoController cc = new ContratoController();
        List<Contrato> contratosDoCliente = cc.listarContratosPorCliente(idCliente);
        
        if (contratosDoCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Você não possui contratos cadastrados.");
        } else {
            StringBuilder sb = new StringBuilder("Seus Contratos:\n");
            for (Contrato con : contratosDoCliente) {
                sb.append("- Contrato nº: ").append(con.getNumero_Contrato())
                  .append(" | Valor: R$ ").append(con.getValor_Honorarios()).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        }
    }
}