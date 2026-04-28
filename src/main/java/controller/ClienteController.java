package controller;

import com.mycompany.easy.administration.model.*;
import java.util.ArrayList;
import java.util.List;
    // atribui valor e incrementa para que o proximo id nao seja igual
public class ClienteController {
    public void adicionarCliente(Cliente c) {
        c.setIdCliente(BancoDeDados.countCli++);
        BancoDeDados.clientes.add(c);
    }
    // método de leitura 
    public List<Cliente> listarTodos() {
        return new ArrayList<>(BancoDeDados.clientes);
    }
}