package periodizacao.treino.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "rotina_exercicio")
@Getter
@Setter
public class RotinaExercicioModel {

    @EmbeddedId
    private RotinaExercicioId id;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("rotinaId")
    @JoinColumn(name = "rotina_id", nullable = false)
    private RotinaModel rotina;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("exercicioId")
    @JoinColumn(name = "exercicio_id", nullable = false)
    private ExercicioModel exercicio;

    @Column(name = "series_planejadas", nullable = false)
    private Integer seriesPlanejadas;

}
