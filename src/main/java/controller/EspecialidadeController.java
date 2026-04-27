package controller;

import com.mycompany.easy.administration.model.Especialidade;
import com.mycompany.easy.administration.model.BancoDeDados;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeController {
    
    // Cadastra uma nova especialidade na lista global atribuindo um ID.
    public void cadastrarEspecialidade(Especialidade especialidade){
        BancoDeDados.especialidades.add(especialidade);
        especialidade.setId_Especialidade(BancoDeDados.especialidades.size());
    }
    
    public void buscaEspecialidadePorId(int id){
        for(Especialidade e : BancoDeDados.especialidades){
            if(e.getId_Especialidade() == id){
                System.out.println("Especialidade: " + e.getNome_Especialidade());
            }
        }
    }
    
    // retorna uma lista com todas as especialidades cadastradas na lista global;
    public List<Especialidade> ListarTodasEspecialidades(){
        return new ArrayList<>(BancoDeDados.especialidades);
    }
    
    // atualiza as especialidades por Id
    public boolean atualizarEspecialidadePorId(int id, Especialidade novo){
        for(int i = 0; i < BancoDeDados.especialidades.size(); i++){
            if(BancoDeDados.especialidades.get(i).getId_Especialidade() == id){
                BancoDeDados.especialidades.set(i, novo);
                return true;
            }
        }
        return false;
    }
    
    public boolean removerEspecialidade(int id){
        return BancoDeDados.especialidades.removeIf(e -> e.getId_Especialidade() == id);
    }
}