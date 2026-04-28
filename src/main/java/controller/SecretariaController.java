package controller;

import com.mycompany.easy.administration.model.BancoDeDados;
import com.mycompany.easy.administration.model.Secretaria;
import java.util.ArrayList;
import java.util.List;

public class SecretariaController {

    public void adicionarSecretaria(Secretaria secretaria) {
        // validação básica para evitar CPF duplicado
        for (Secretaria s : BancoDeDados.secretarias) {
            if (s.getCpf().equals(secretaria.getCpf())) {
                throw new IllegalArgumentException("Erro: Já existe uma secretária com este CPF.");
            }
        }
        // atribui ID e incrementa o contador para que não se repita
        secretaria.setIdSecretaria(BancoDeDados.countSec++);
        BancoDeDados.secretarias.add(secretaria);
    }
    // método de leitura
    public List<Secretaria> listarTodasSecretarias() {
        return new ArrayList<>(BancoDeDados.secretarias);
    }
}