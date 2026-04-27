package controller;

import com.mycompany.easy.administration.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();
    
    public void adicionarCliente(Cliente cliente){
        for(Cliente c : clientes){
            if(c.getCPF().equals(cliente.getCPF())){
                throw new IllegalArgumentException("Já existe um cliente com esse CPF.");
            }
        }
        clientes.add(cliente);
        cliente.setId_Cliente(clientes.size());
    }
    
    public void buscaClientePorId(int id){
        for(Cliente c : clientes){
            if(c.getId_Cliente() == id){
                System.out.println("Nome: " + c.getNome());
                System.out.println("Id: " + c.getId_Cliente());
                System.out.println("CPF: " + c.getCPF());
                System.out.println("Email: " + c.getEmail());
            }
        }
    }
    
    public List<Cliente> ListarTodosClientes(){
        return new ArrayList<>(clientes);
    }
    
    public boolean atualizarCliente(int id, Cliente novo, String senha){
        for(int i = 0; i < clientes.size(); i++){
            if(clientes.get(i).getId_Cliente() == id && clientes.get(i).getSenha() == senha){
                clientes.set(i, novo);
                return true;
            }
        }
        return false;
    }
    
    public boolean removerCliente(int id){
        return clientes.removeIf(a -> a.getId_Cliente() == id);
    }
}
