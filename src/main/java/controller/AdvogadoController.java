package controller;

import com.mycompany.easy.administration.model.Advogado;
import com.mycompany.easy.administration.model.BancoDeDados; 
import java.util.ArrayList;
import java.util.List;

public class AdvogadoController {
    
    // adiciona um novo advogado à lista global caso o número OAB não exista
    public void adicionarAdvogado(Advogado advogado){
        for(Advogado a : BancoDeDados.advogados){
            if(a.getNumeroOAB().equals(advogado.getNumeroOAB())){
                throw new IllegalArgumentException("Número da OAB já cadastrado!");
            }
        }
        // cadastra na lista global
        BancoDeDados.advogados.add(advogado);
        advogado.setId_Advogado(BancoDeDados.advogados.size());
    }
    
    // consulta advogados por ID na lista global
    public void buscaAdvogadoPorId(int id){
        for(Advogado a : BancoDeDados.advogados){
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
    
    // lista todos da lista global
    public List<Advogado> ListarTodosAdvogados(){
        return new ArrayList<>(BancoDeDados.advogados);
    }
    
    // atualiza os advogados na lista global
    public boolean atualizarAdvogado(int id, Advogado novo, String senha){
        for(int i = 0; i < BancoDeDados.advogados.size(); i++){
            if(BancoDeDados.advogados.get(i).getId_Advogado() == id && 
               BancoDeDados.advogados.get(i).getSenha().equals(senha)){ // Use .equals para String
               
               BancoDeDados.advogados.set(i, novo); 
               return true;
            }
        }
        return false;
    }

    public boolean removerAdvogado(int id){
        return BancoDeDados.advogados.removeIf(a -> a.getId_Advogado() == id);
    }
}