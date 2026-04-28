package controller;

import com.mycompany.easy.administration.model.*;
import java.util.ArrayList;
import java.util.List;

public class AdvogadoController {
    
    // ESTE MÉTODO ESTAVA FALTANDO E POR ISSO O NETBEANS DAVA ERRO
    public void adicionarAdvogado(Advogado a) {
        // Define o ID incrementando o contador do Banco de Dados
        a.setIdAdvogado(BancoDeDados.countAdv++);
        BancoDeDados.advogados.add(a);
    }

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
    
    public List<Advogado> listarTodos() {
        return new ArrayList<>(BancoDeDados.advogados);
    }
}