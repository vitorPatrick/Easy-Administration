package controller;

import com.mycompany.easy.administration.model.*;

public class Login {

    // tenta autenticar o usuário percorrendo todas as listas do banco De dados. 
    //retorna o objeto (Advogado, Cliente ou Secretaria) se encontrado.
    public Object autenticar(String email, String senha) {
        
        // 1. Verifica na lista de Advogados(as)
        for (Advogado a : BancoDeDados.advogados) {
            if (a.getEmail().equalsIgnoreCase(email) && a.getSenha().equals(senha)) {
                return a;
            }
        }

        // verifica na lista de secretários(as)
        for (Secretaria s : BancoDeDados.secretarias) {
            if (s.getEmial().equalsIgnoreCase(email) && s.getSenha().equals(senha)) {
                return s;
            }
        }

        // verifica na lista de clientes
        for (Cliente c : BancoDeDados.clientes) {
            if (c.getEmail().equalsIgnoreCase(email) && c.getSenha().equals(senha)) {
                return c;
            }
        }

        // se chegar aqui, as credenciais estão incorretas
        return null; 
    }
}