package controller;
import com.mycompany.easy.administration.model.*;

public class Login {
    public Object autenticar(String email, String senha) {
        for (Advogado a : BancoDeDados.advogados) 
            if (a.getEmail().equalsIgnoreCase(email) && a.getSenha().equals(senha)) return a;
        for (Secretaria s : BancoDeDados.secretarias) 
            if (s.getEmail().equalsIgnoreCase(email) && s.getSenha().equals(senha)) return s;
        for (Cliente c : BancoDeDados.clientes) 
            if (c.getEmail().equalsIgnoreCase(email) && c.getSenha().equals(senha)) return c;
        return null;
    }
}