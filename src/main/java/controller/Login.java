package controller;

import com.mycompany.easy.administration.model.*;

/**
 * Autenticador do sistema.
 * Agora utiliza Polimorfismo ao retornar o tipo 'Usuario'.
 */
public class Login {
    
    // Mudamos de 'Object' para 'Usuario'
    public Usuario autenticar(String email, String senha) {
        
        // 1. Verifica na lista de Advogados
        for (Advogado a : BancoDeDados.advogados) {
            if (a.getEmail().equalsIgnoreCase(email) && a.getSenha().equals(senha)) {
                return a; // Retorna um Advogado (que é um Usuario)
            }
        }
        
        // 2. Verifica na lista de Secretarias
        for (Secretaria s : BancoDeDados.secretarias) {
            if (s.getEmail().equalsIgnoreCase(email) && s.getSenha().equals(senha)) {
                return s; // Retorna uma Secretaria (que é um Usuario)
            }
        }
        
        // 3. Verifica na lista de Clientes
        for (Cliente c : BancoDeDados.clientes) {
            if (c.getEmail().equalsIgnoreCase(email) && c.getSenha().equals(senha)) {
                return c; // Retorna um Cliente (que é um Usuario)
            }
        }
        
        // Se percorrer tudo e não encontrar correspondência
        return null;
    }
}