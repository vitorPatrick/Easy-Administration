package controller;

import com.mycompany.easy.administration.model.BancoDeDados;
import com.mycompany.easy.administration.model.Secretaria;
import java.util.ArrayList;
import java.util.List;

public class SecretariaController {

    public void adicionarSecretaria(Secretaria secretaria) {
        // Validação básica para evitar CPFs duplicados
        for (Secretaria s : BancoDeDados.secretarias) {
            if (s.getCpf().equals(secretaria.getCpf())) {
                throw new IllegalArgumentException("Erro: Já existe uma secretária com este CPF.");
            }
        }
        // Atribui ID e incrementa o contador global
        secretaria.setIdSecretaria(BancoDeDados.countSec++);
        BancoDeDados.secretarias.add(secretaria);
    }

    public List<Secretaria> listarTodasSecretarias() {
        return new ArrayList<>(BancoDeDados.secretarias);
    }

    public boolean removerSecretaria(int id) {
        return BancoDeDados.secretarias.removeIf(s -> s.getIdSecretaria() == id);
    }
}