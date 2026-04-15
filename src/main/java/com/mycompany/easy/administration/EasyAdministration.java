package com.mycompany.easy.administration;

import com.mycompany.easy.administration.model.Advogado;
import controller.AdvogadoController;

public class EasyAdministration {

    public static void main(String[] args) {
        AdvogadoController controller = new AdvogadoController();
        Advogado a = new Advogado("Vinicius","Criminal","000000/DF","6199999",
                                  "Vini@gmail.com","12345");
 
        controller.adicionarAdvogado(a);
        controller.buscaAdvogadoPorId(1);
    }
}
