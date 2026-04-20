package com.mycompany.easy.administration;

import com.mycompany.easy.administration.model.Advogado;
import com.mycompany.easy.administration.model.Especialidade;
import controller.AdvogadoController;
import controller.EspecialidadeController;

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
    }
}
