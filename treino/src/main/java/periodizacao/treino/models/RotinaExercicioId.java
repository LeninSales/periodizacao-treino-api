package periodizacao.treino.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RotinaExercicioId implements Serializable {
    private Integer rotinaId;
    private Integer exercicioId;
}
