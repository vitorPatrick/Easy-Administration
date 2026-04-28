package controller;
import com.mycompany.easy.administration.model.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeController {
    public void cadastrarEspecialidade(Especialidade e) {
        e.setId_Especialidade(BancoDeDados.countEsp++);
        BancoDeDados.especialidades.add(e);
    }
    public List<Especialidade> listarTodas() { return new ArrayList<>(BancoDeDados.especialidades); }
}