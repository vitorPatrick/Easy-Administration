package controller;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.easy.administration.model.Contrato;
import com.mycompany.easy.administration.model.Advogado;
import com.mycompany.easy.administration.model.BancoDeDados; 

public class ContratoController {

    // Adiciona um novo Contrato validando que o número do contrato ainda não existe
    public void adicionarContrato(Contrato contrato) {
        for (Contrato c : BancoDeDados.contratos) {
            if (c.getNumero_Contrato().equals(contrato.getNumero_Contrato())) {
                throw new IllegalArgumentException("Número do contrato já cadastrado!");
            }
        }
        BancoDeDados.contratos.add(contrato);
        contrato.setId_Contrato(BancoDeDados.contratos.size());
    }

    // busca contrato por ID e exibe seus dados
    public void buscaContratoPorId(int id) {
        for (Contrato c : BancoDeDados.contratos) {
            if (c.getId_Contrato() == id) {
                System.out.println("Id Contrato: " + c.getId_Contrato());
                System.out.println("Numero do Contrato: " + c.getNumero_Contrato());
                System.out.println("Valor dos Honorarios: R$ " + c.getValor_Honorarios());
                System.out.println("Id Cliente: " + c.getId_Cliente());
                System.out.println("Id Advogado: " + c.getId_Advogado());
                System.out.println("Id Especialidade: " + c.getId_Especialidade());
            }
        }
    }

    // lista todos os contratos cadastrados
    public List<Contrato> listarTodosContratos() {
        return new ArrayList<>(BancoDeDados.contratos);
    }

    // lista apenas os contratos de um cliente específico (controle de acesso LGPD)
    public List<Contrato> listarContratosPorCliente(int idCliente) {
        List<Contrato> resultado = new ArrayList<>();
        for (Contrato c : BancoDeDados.contratos) {
            if (c.getId_Cliente() == idCliente) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    // remove um contrato pelo ID
    public boolean removerContrato(int id) {
        return BancoDeDados.contratos.removeIf(c -> c.getId_Contrato() == id);
    }

    // vincula automaticamente um advogado ao contrato com base na especialidade
    // busca diretamente na lista global do banco de dados dos advogados
    public Advogado vincularAdvogadoPorEspecialidade(int idEspecialidade) {
        for (Advogado a : BancoDeDados.advogados) {
            if (a.getEspecialidade() != null &&
                a.getEspecialidade().equals(String.valueOf(idEspecialidade))) {
                return a;
            }
        }
        throw new IllegalArgumentException("Nenhum advogado disponível para esta especialidade!");
    }
}