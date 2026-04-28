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
        
        // 1. Exibir dados básicos
        add(new JLabel("Bem-vindo, Dr(a). " + a.getNome(), SwingConstants.CENTER));
        add(new JLabel("Especialidade: " + a.getEspecialidade(), SwingConstants.CENTER));
        
        // 2. Botão para exibir contratos detalhados
        JButton btnContratos = new JButton("Ver Meus Contratos");
        btnContratos.addActionListener(e -> exibirMeusContratos(a.getId_Advogado()));
        add(btnContratos);

        add(new JButton("Minhas Especialidades"));
        
        // 3. Botão Sair
        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(e -> System.exit(0)); // Encerra o programa
        add(btnSair);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Método que busca e exibe os contratos detalhados
    private void exibirMeusContratos(int idAdvogado) {
        ContratoController cc = new ContratoController();
        List<Contrato> todos = cc.listarTodosContratos();
        
        StringBuilder sb = new StringBuilder("--- Meus Contratos ---\n\n");
        int contagem = 0;
        
        for (Contrato c : todos) {
            if (c.getId_Advogado() == idAdvogado) {
                sb.append("Contrato nº: ").append(c.getNumero_Contrato())
                  .append(" | Valor: R$ ").append(String.format("%.2f", c.getValor_Honorarios()))
                  .append("\n");
                contagem++;
            }
        }
        
        if (contagem == 0) {
            JOptionPane.showMessageDialog(this, "Você não possui contratos sob sua responsabilidade.");
        } else {
            sb.append("\nTotal de contratos: ").append(contagem);
            JOptionPane.showMessageDialog(this, sb.toString());
        }
    }
}