package controller;

import com.mycompany.easy.administration.model.Secretaria;
import java.util.ArrayList;
import java.util.List;

public class SecretariaController {
    private List<Secretaria> secretarias = new ArrayList<>();
    
    public void adicionarSecretaria(Secretaria secretaria){
        for(Secretaria s : secretarias){
            if(s.getCPF().equals(secretaria.getCPF())){
                throw new IllegalArgumentException("Ja existe uma secretária com esse CPF.");
            }
        }
        secretarias.add(secretaria);
        secretaria.setId_Secretaria(secretarias.size());
    }
    
    //Consulta secretaria por ID
    public void buscaSecretariaPorId(int id){
        for(Secretaria s : secretarias){
            if(s.getId_Secretaria() == id){
                System.out.println("Nome: " + s.getNome());
                System.out.println("Id: " + s.getId_Secretaria());
                System.out.println("Email: " + s.getEmial());
            }
        }
    }
    //Listar todas as secretarias
    public List<Secretaria> ListarTodasSecretarias(){
        return new ArrayList<>(secretarias);
    }
    public boolean removerSecretariaPorId(int id){
        return secretarias.removeIf(s -> s.getId_Secretaria() == id);
    }
}
