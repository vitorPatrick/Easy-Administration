package controller;
import com.mycompany.easy.administration.model.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoController {
    public void adicionarContrato(Contrato c) {
        c.setIdContrato(BancoDeDados.countCon++);
        BancoDeDados.contratos.add(c);
    }
    public List<Contrato> listarTodos() { return new ArrayList<>(BancoDeDados.contratos); }
}