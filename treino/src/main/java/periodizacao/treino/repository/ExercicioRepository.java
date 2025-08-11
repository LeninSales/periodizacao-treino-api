package periodizacao.treino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import periodizacao.treino.models.ExercicioModel;

import java.util.List;

@Repository
public interface ExercicioRepository extends JpaRepository<ExercicioModel, Integer> {
    List<ExercicioModel> findByUsuarioId(Integer usuarioId);

    List<ExercicioModel> findByUsuarioIdIsNull();
}
