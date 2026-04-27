package com.mycompany.easy.administration;

import com.mycompany.easy.administration.model.Advogado;
import com.mycompany.easy.administration.model.Cliente;
import com.mycompany.easy.administration.model.Especialidade;
import com.mycompany.easy.administration.model.Secretaria;
import controller.AdvogadoController;
import controller.ClienteController;
import controller.EspecialidadeController;
import controller.SecretariaController;

public class EasyAdministration {

    public static void main(String[] args) {
        AdvogadoController Acontroller = new AdvogadoController();
        Advogado a = new Advogado("Vinicius",/*Precisa ajustar a especialidade para buscar opção na lista*/
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
        
        Ccontroller.adicionarCliente(c);
        Ccontroller.buscaClientePorId(1);
    }
}
