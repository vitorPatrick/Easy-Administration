package controller;

import com.mycompany.easy.administration.model.Cliente;
import com.mycompany.easy.administration.model.BancoDeDados; 
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    
   // Agora utilizamos o banco de dados diretamente
    
    public void adicionarCliente(Cliente cliente){
        for(Cliente c : BancoDeDados.clientes){
            if(c.getCPF().equals(cliente.getCPF())){
                throw new IllegalArgumentException("Ja existe um cliente com esse CPF.");
            }
        }
        BancoDeDados.clientes.add(cliente);
        cliente.setId_Cliente(BancoDeDados.clientes.size());
    }
    
    public void buscaClientePorId(int id){
        for(Cliente c : BancoDeDados.clientes){
            if(c.getId_Cliente() == id){
                System.out.println("Nome: " + c.getNome());
                System.out.println("Id: " + c.getId_Cliente());
                System.out.println("CPF: " + c.getCPF());
                System.out.println("Email: " + c.getEmail());
            }
        }
    }
    
    public List<Cliente> ListarTodosClientes(){
        return new ArrayList<>(BancoDeDados.clientes);
    }
    
    public boolean atualizarCliente(int id, Cliente novo, String senha){
        for(int i = 0; i < BancoDeDados.clientes.size(); i++){
            // alterado para usar .equals() na comparação de Strings para verificar se a senha é a mesma cadastrada
            if(BancoDeDados.clientes.get(i).getId_Cliente() == id && 
               BancoDeDados.clientes.get(i).getSenha().equals(senha)){
                
                BancoDeDados.clientes.set(i, novo);
                return true;
            }
        }
        return false;
    }
    
    public boolean removerCliente(int id){
        return BancoDeDados.clientes.removeIf(a -> a.getId_Cliente() == id);
    }
}