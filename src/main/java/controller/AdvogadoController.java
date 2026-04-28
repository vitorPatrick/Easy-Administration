package controller;

import com.mycompany.easy.administration.model.*;
import java.util.ArrayList;
import java.util.List;

public class AdvogadoController {
    
    
    public void adicionarAdvogado(Advogado a) {
    // define o ID e incrementa o contador do banco de dados para seguir de forma cronológica
        a.setIdAdvogado(BancoDeDados.countAdv++);
        BancoDeDados.advogados.add(a);
    }
    // fazem parte da regra de negócio e faz associação entre entidades
    public List<Cliente> buscarClientesDoAdvogado(int idAdvogado) {
        List<Cliente> lista = new ArrayList<>();
        for (Contrato c : BancoDeDados.contratos) {
            if (c.getIdAdvogado() == idAdvogado) {
                for (Cliente cli : BancoDeDados.clientes) {
                    if (cli.getIdCliente() == c.getIdCliente()) {
                        lista.add(cli);
                    }
                }
            }
        }
        return lista;
    }
    // método de leitura
    public List<Advogado> listarTodos() {
        return new ArrayList<>(BancoDeDados.advogados);
    }
}