package com.mycompany.easy.administration;

import com.mycompany.easy.administration.model.Contrato;
import com.mycompany.easy.administration.model.Advogado;
import com.mycompany.easy.administration.model.Cliente;
import com.mycompany.easy.administration.model.Especialidade;
import com.mycompany.easy.administration.model.Secretaria;
import controller.AdvogadoController;
import controller.ClienteController;
import controller.EspecialidadeController;
import controller.SecretariaController;
import controller.ContratoController;

public class EasyAdministration {

    public static void main(String[] args) {
        AdvogadoController Acontroller = new AdvogadoController();
        Advogado a = new Advogado("Vinicius", /*Precisa ajustar a especialidade para buscar opção na lista*/
                                  "Criminal","000000/DF","6199999",
                                  "Vini@gmail.com","12345");
 
        Acontroller.adicionarAdvogado(a);
        Acontroller.buscaAdvogadoPorId(1);
        
        EspecialidadeController Econtroller = new EspecialidadeController();
        Especialidade e = new Especialidade("Criminal");
        
        Econtroller.cadastrarEspecialidade(e);
        Econtroller.buscaEspecialidadePorId(1);
        
        SecretariaController Scontroller = new SecretariaController();
        Secretaria s = new Secretaria("Marta","0918237","Marta@gmail.com","12341");
        
        Scontroller.adicionarSecretaria(s);
        Scontroller.buscaSecretariaPorId(1);
        
        ClienteController Ccontroller = new ClienteController();
        Cliente c = new Cliente("Patrick","12341","Patrick@yahoo.com","12345");
        Cliente c1 = new Cliente("PatrickS", "99999", "PatrickS@yahoo.com", "12345");
        
        Ccontroller.adicionarCliente(c);
        Ccontroller.adicionarCliente(c1);
        Ccontroller.buscaClientePorId(2);
        
   ContratoController Contcontroller = new ContratoController();
   Contrato contrato = new Contrato("001", 1500.00, 1, 1, 1);
   Contrato contrato2 = new Contrato("002", 2000.00, 2, 1, 1);
   
   Contcontroller.adicionarContrato(contrato);
   Contcontroller.adicionarContrato(contrato2);
   Contcontroller.buscaContratoPorId(1);

   
        
    }
}