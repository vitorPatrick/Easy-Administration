package com.mycompany.easy.administration;

import com.mycompany.easy.administration.model.*;
import controller.*;
import com.mycompany.easy.administration.Interface.TelaLogin; 
import javax.swing.SwingUtilities; 

public class EasyAdministration {

    public static void main(String[] args) {
        // informações para teste de cadastro
        AdvogadoController Acontroller = new AdvogadoController();
        Advogado a = new Advogado("Vinicius", "Criminal", "000000/DF", "6199999", "vini@email.com", "123");
        Acontroller.adicionarAdvogado(a);

        EspecialidadeController Econtroller = new EspecialidadeController();
        Especialidade e = new Especialidade("Criminal");
        Econtroller.cadastrarEspecialidade(e);

        SecretariaController Scontroller = new SecretariaController();
        Secretaria s = new Secretaria("Marta", "0918237", "Marta@gmail.com", "12341");
        Scontroller.adicionarSecretaria(s);

        ClienteController Ccontroller = new ClienteController();
        Cliente c = new Cliente("Patrick", "12341", "Patrick@yahoo.com", "12345");
        Ccontroller.adicionarCliente(c);

        ContratoController Contcontroller = new ContratoController();
        Contrato contrato = new Contrato("001", 1500.00, 1, 1, 1);
        Contcontroller.adicionarContrato(contrato);

        
        // esse bloco inicia a interface gráfica
        SwingUtilities.invokeLater(() -> {
            new TelaLogin();
        });
    }
}