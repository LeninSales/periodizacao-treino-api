package periodizacao.treino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import periodizacao.treino.dto.RotinaExercicioDto;
import periodizacao.treino.models.ExercicioModel;
import periodizacao.treino.models.RotinaExercicioId;
import periodizacao.treino.models.RotinaExercicioModel;
import periodizacao.treino.models.RotinaModel;
import periodizacao.treino.repository.ExercicioRepository;
import periodizacao.treino.repository.RotinaExercicioRepository;
import periodizacao.treino.repository.RotinaRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RotinaExercicioService {

    @Autowired
    private RotinaExercicioRepository repository;

    @Autowired
    private RotinaRepository rotinaRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Transactional
    public RotinaExercicioModel adicionaExercicioARotina(RotinaExercicioDto dto) {
        RotinaModel rotina = pegaEntidadePorId(rotinaRepository, dto.rotinaId(), "Rotina não encontrada.");

        ExercicioModel exercicio = pegaEntidadePorId(exercicioRepository, dto.exercicioId(), "Exercicio não encontrado.");

        RotinaExercicioModel rotinaExercicio = new RotinaExercicioModel();
        rotinaExercicio.setExercicio(exercicio);
        rotinaExercicio.setRotina(rotina);
        rotinaExercicio.setSeriesPlanejadas(dto.seriesPlanejadas());

        return repository.save(rotinaExercicio);
    }

    @Transactional
    public RotinaExercicioModel atualizarExercicioNaRotina(RotinaExercicioDto dto) {
        RotinaExercicioId id = new RotinaExercicioId(dto.rotinaId(), dto.exercicioId());

        RotinaExercicioModel rotinaExercicioExistente = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Associação entre rotina e exercício não encontrada."));

        rotinaExercicioExistente.setSeriesPlanejadas(dto.seriesPlanejadas());

        return repository.save(rotinaExercicioExistente);
    }

    @Transactional
    public void removerExercicioDaRotina(Integer rotinaId, Integer exercicioId) {
        RotinaExercicioId id = new RotinaExercicioId(rotinaId, exercicioId);

        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Associação entre rotina e exercício não encontrada.");
        }
        repository.deleteById(id);
    }

    public List<RotinaExercicioModel> listarExerciciosPorRotina(Integer rotinaId) {
        pegaEntidadePorId(rotinaRepository, rotinaId, "Rotina não encontrada.");

        return repository.findByRotinaId(rotinaId);
    }

    private <T, ID> T pegaEntidadePorId(JpaRepository<T, ID> repository, ID id, String errorMessage) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException(errorMessage));
    }
}
