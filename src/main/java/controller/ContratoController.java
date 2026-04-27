package controller;
 
import java.util.ArrayList;
import java.util.List;
import com.mycompany.easy.administration.model.Contrato;
import com.mycompany.easy.administration.model.Advogado;
import com.mycompany.easy.administration.model.Especialidade;
 
public class ContratoController {
    // Cria uma lista de Contratos que serão salvos em memória
    private List<Contrato> contratos = new ArrayList<>();
 
    // Adiciona um novo Contrato validando que o número do contrato ainda não existe
    public void adicionarContrato(Contrato contrato) {
        for (Contrato c : contratos) {
            if (c.getNumero_Contrato().equals(contrato.getNumero_Contrato())) {
                throw new IllegalArgumentException("Número do contrato já cadastrado!");
            }
        }
        contratos.add(contrato);
        contrato.setId_Contrato(contratos.size());
    }
 
    // Busca contrato por ID e exibe seus dados
    public void buscaContratoPorId(int id) {
        for (Contrato c : contratos) {
            if (c.getId_Contrato() == id) {
                System.out.println("Id Contrato: " + c.getId_Contrato());
                System.out.println("Número do Contrato: " + c.getNumero_Contrato());
                System.out.println("Valor dos Honorários: R$ " + c.getValor_Honorarios());
                System.out.println("Id Cliente: " + c.getId_Cliente());
                System.out.println("Id Advogado: " + c.getId_Advogado());
                System.out.println("Id Especialidade: " + c.getId_Especialidade());
            }
        }
    }
 
    // Lista todos os contratos cadastrados
    public List<Contrato> listarTodosContratos() {
        return new ArrayList<>(contratos);
    }
 
    // Lista apenas os contratos de um cliente específico (controle de acesso LGPD)
    public List<Contrato> listarContratosPorCliente(int idCliente) {
        List<Contrato> resultado = new ArrayList<>();
        for (Contrato c : contratos) {
            if (c.getId_Cliente() == idCliente) {
                resultado.add(c);
            }
        }
        return resultado;
    }
 
    // Remove um contrato pelo ID
    public boolean removerContrato(int id) {
        return contratos.removeIf(c -> c.getId_Contrato() == id);
    }
 
    // Vincula automaticamente um advogado ao contrato com base na especialidade
    // Percorre a lista de advogados e retorna o primeiro que possui a especialidade solicitada
    public Advogado vincularAdvogadoPorEspecialidade(int idEspecialidade, List<Advogado> advogados) {
        for (Advogado a : advogados) {
            if (a.getEspecialidade() != null &&
                a.getEspecialidade().equals(String.valueOf(idEspecialidade))) {
                return a;
            }
        }
        // Lança erro se nenhum advogado com a especialidade for encontrado
        throw new IllegalArgumentException("Nenhum advogado disponível para esta especialidade!");
    }
}