package periodizacao.treino.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import periodizacao.treino.dto.ExercicioDto;
import periodizacao.treino.models.ExercicioModel;
import periodizacao.treino.service.ExercicioService;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ExercicioController {

    @Autowired
    private ExercicioService service;

    public ExercicioModel criarExercicio(ExercicioDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Dados do exercício não informados.");
        }
        return service.salvaExercicio(dto);
    }

    public List<ExercicioModel> listarExercicios() {
        List<ExercicioModel> exercicios = service.listaExercicio();
        if (exercicios.isEmpty()) {
            throw new NoSuchElementException("Nenhum exercício encontrado.");
        }
        return exercicios;
    }

    public ExercicioModel buscarUmExercicio(Integer id) {
        ExercicioModel exercicio = service.pegaUmExercicio(id);
        return exercicio;
    }

    public ExercicioModel atualizarExercicio(Integer id, ExercicioDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Dados do exercício não informados.");
        }
        return service.atualizaExercicio(id, dto);
    }

    public void deletarExercicio(Integer id) {
        service.deletaExercicio(id);
    }
}
