package periodizacao.treino.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import periodizacao.treino.dto.ExercicioDto;
import periodizacao.treino.models.ExercicioModel;
import periodizacao.treino.repository.ExercicioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository repository;

    public ExercicioModel salvaExercicio(ExercicioDto dto) {
        ExercicioModel exercicio = new ExercicioModel();
        BeanUtils.copyProperties(dto, exercicio);
        return repository.save(exercicio);
    }

    public List<ExercicioModel> listaExercicio() {
        return repository.findAll();
    }

    public List<ExercicioModel> listaExerciciosEExeciciosPorUsuario(ExercicioDto dto) {
        List<ExercicioModel> exerciciosGeral = new ArrayList<>();
        exerciciosGeral.addAll(repository.findByUsuarioId(dto.usuarioID()));
        exerciciosGeral.addAll(repository.findByUsuarioIdIsNull());

        return exerciciosGeral;
    }

    public ExercicioModel pegaUmExercicioPorId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Exercicio não encontrado."));
    }

    public ExercicioModel atualizaExercicio(Integer id, ExercicioDto dto) {
        ExercicioModel exercicio = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Exercicio não encontrado."));
        BeanUtils.copyProperties(dto, exercicio, "id");
        return repository.save(exercicio);
    }

    public void deletaExercicio(Integer id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Exercicio não encontrado para exclusão.");
        }
        repository.deleteById(id);
    }
}
