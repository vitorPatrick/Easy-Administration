package controller;

import java.util.ArrayList;
import java.util.List;

//Import da classe Advogado que se encontra no package model;
import com.mycompany.easy.administration.model.Advogado;

public class AdvogadoController {
    //Cria uma lista de Advogados que serão salvos em memória 
    private List<Advogado> advogados = new ArrayList<>();
    
    //Adicionar um novo Advogado a lista caso o numeroOAB digitado ainda não exista na lista;
    public void adicionarAdvogado(Advogado advogado){
        for(Advogado a : advogados){
            if(a.getNumeroOAB().equals(advogado.getNumeroOAB())){
                //Gera um erro caso o NumeroOAB digitado já exista na base;
                throw new IllegalArgumentException("Número da OAB já cadastrado!");
            }
        }
        //Cadastra um novo Advogado na lista;
        advogados.add(advogado);
        advogado.setId_Advogado(advogados.size());
    }
    
    //Consulta advogado por ID
    public void buscaAdvogadoPorId(int id){
        //retirna os dados de um Advogado caso o seu ID seja encontrado na lista de Advogados;
        for(Advogado a : advogados){
            if(a.getId_Advogado() == id){
                System.out.println("Nome: " + a.getNome());
                System.out.println("Id: " + a.getId_Advogado());
                System.out.println("Especialidade: " + a.getEspecialidade());
                System.out.println("Numero OAB: " + a.getNumeroOAB());
                System.out.println("Telefone: " + a.getTelefone());
                System.out.println("Email: " + a.getEmail());
            }
        }
    }
    
    //Listar todos
    public List<Advogado> ListarTodosAdvogados(){
        //retorna todos os Advogados presentes na lista;
        return new ArrayList<>(advogados);
    }
    
    //Atualizar advogado
    public boolean atualizarAdvogado(int id, Advogado novo, String senha){
        //percorre toda a lista de Advogados buscando um advigado com o Id recebido;
        for(int i = 0; i < advogados.size(); i++){
            //Valida o ID e senha antes de atualizar os dados de um Advogado;
            if(advogados.get(i).getId_Advogado() == id && advogados.get(i).getSenha() == senha){
               advogados.set(i, novo); 
               return true;
            }
        }
        return false;
    }

    public boolean removerAdvogado(int id){
        return advogados.removeIf(a -> a.getId_Advogado() == id);
    }
}
