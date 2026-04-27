package controller;

import com.mycompany.easy.administration.model.Secretaria;
import com.mycompany.easy.administration.model.BancoDeDados; 
import java.util.ArrayList;
import java.util.List;

public class SecretariaController {
    
    public void adicionarSecretaria(Secretaria secretaria){
        for(Secretaria s : BancoDeDados.secretarias){
            if(s.getCPF().equals(secretaria.getCPF())){
                throw new IllegalArgumentException("Ja existe uma secretária com esse CPF.");
            }
        }
        BancoDeDados.secretarias.add(secretaria);
        secretaria.setId_Secretaria(BancoDeDados.secretarias.size());
    }
    
    // consulta secretaria por ID
    public void buscaSecretariaPorId(int id){
        for(Secretaria s : BancoDeDados.secretarias){
            if(s.getId_Secretaria() == id){
                System.out.println("Nome: " + s.getNome());
                System.out.println("Id: " + s.getId_Secretaria());
                System.out.println("Email: " + s.getEmial());
            }
        }
    }
    
    // lista todas as secretarias
    public List<Secretaria> ListarTodasSecretarias(){
        return new ArrayList<>(BancoDeDados.secretarias);
    }
    
    public boolean removerSecretariaPorId(int id){
        return BancoDeDados.secretarias.removeIf(s -> s.getId_Secretaria() == id);
    }
}