package periodizacao.treino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import periodizacao.treino.models.ExercicioModel;

@Repository
public interface ExercicioRepository extends JpaRepository<ExercicioModel, Integer> {

}
