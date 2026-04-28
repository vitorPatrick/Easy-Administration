package controller;

import com.mycompany.easy.administration.model.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    public void adicionarCliente(Cliente c) {
        c.setIdCliente(BancoDeDados.countCli++);
        BancoDeDados.clientes.add(c);
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(BancoDeDados.clientes);
    }
}