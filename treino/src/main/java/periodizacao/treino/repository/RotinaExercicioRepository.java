package periodizacao.treino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import periodizacao.treino.models.RotinaExercicioId;
import periodizacao.treino.models.RotinaExercicioModel;

import java.util.List;

public interface RotinaExercicioRepository extends JpaRepository<RotinaExercicioModel, RotinaExercicioId> {
    List<RotinaExercicioModel> findByRotinaId(Integer rotinaId);
}
