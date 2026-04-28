package controller;
import com.mycompany.easy.administration.model.*;
import java.util.ArrayList;
import java.util.List;
    // atribui valor e incrementa para que o proximo id nao seja igual
public class EspecialidadeController {
    public void cadastrarEspecialidade(Especialidade e) {
        e.setId_Especialidade(BancoDeDados.countEsp++);
        BancoDeDados.especialidades.add(e);
    }
    // método de leitura
    public List<Especialidade> listarTodas() { return new ArrayList<>(BancoDeDados.especialidades); }
}