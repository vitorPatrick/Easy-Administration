package controller;

import com.mycompany.easy.administration.model.Advogado;
import com.mycompany.easy.administration.model.Especialidade;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeController {
    //Cria uma lista de Especialidades;
    private List<Especialidade> especialidades = new ArrayList<>();
    
    //Cadastra uma nova especialidade na lista de especialidades atribuindo um ID.
    public void cadastrarEspecialidade(Especialidade especialidade){
        especialidades.add(especialidade);
        especialidade.setId_Especialidade(especialidades.size());
    }
    
    public void buscaEspecialidadePorId(int id){
        for(Especialidade e : especialidades){
            if(e.getId_Especialidade() == id){
                System.out.println("Especilidade: " + e.getNome_Especialidade());
            }
        }
    }
    
    //Retorna uma lista com todas as especialidades cadastradas;
    public List<Especialidade> ListarTodasEspecialidades(){
        return new ArrayList<>(especialidades);
    }
    
    //Atualizar  Especialidade por Id
    public boolean atualizarEspecialidadePorId(int id, Especialidade novo){
        for(int i = 0; i < especialidades.size(); i++){
            if(especialidades.get(id).getId_Especialidade() == id){
                especialidades.set(i, novo);
                return true;
            }
        }
        return false;
    }
    
    public boolean removerEspecialidade(int id){
        return especialidades.removeIf(e -> e.getId_Especialidade() == id);
    }
}