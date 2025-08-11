package periodizacao.treino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import periodizacao.treino.models.DiaSemana;
import periodizacao.treino.models.RotinaModel;

import java.util.List;

public interface RotinaRepository extends JpaRepository<RotinaModel, Integer> {
    List<RotinaModel> findByUsuarioId(Integer usuarioId);}

