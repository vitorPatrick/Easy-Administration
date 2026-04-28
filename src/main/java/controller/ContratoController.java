package controller;
import com.mycompany.easy.administration.model.*;
import java.util.ArrayList;
import java.util.List;
    // atribui valor e incrementa para que o proximo id nao seja igual
public class ContratoController {
    public void adicionarContrato(Contrato c) {
        c.setIdContrato(BancoDeDados.countCon++);
        BancoDeDados.contratos.add(c);
    }
    // método de leitura
    public List<Contrato> listarTodos() { return new ArrayList<>(BancoDeDados.contratos); }
}