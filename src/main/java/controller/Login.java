package controller;

import com.mycompany.easy.administration.model.*;

// autenticador do sistema
public class Login {
    
    public Usuario autenticar(String email, String senha) {
        
        // verifica na lista de Advogados
        for (Advogado a : BancoDeDados.advogados) {
            if (a.getEmail().equalsIgnoreCase(email) && a.getSenha().equals(senha)) {
                return a; // Retorna um Advogado (que é um Usuario)
            }
        }
        
        // verifica na lista de Secretarias
        for (Secretaria s : BancoDeDados.secretarias) {
            if (s.getEmail().equalsIgnoreCase(email) && s.getSenha().equals(senha)) {
                return s; // Retorna uma Secretaria (que é um Usuario)
            }
        }
        
        // verifica na lista de Clientes
        for (Cliente c : BancoDeDados.clientes) {
            if (c.getEmail().equalsIgnoreCase(email) && c.getSenha().equals(senha)) {
                return c; // Retorna um Cliente (que é um Usuario)
            }
        }
        
        // se percorrer tudo e não encontrar correspondência
        return null;
    }
}