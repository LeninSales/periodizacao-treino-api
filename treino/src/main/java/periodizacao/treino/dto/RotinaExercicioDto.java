package periodizacao.treino.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RotinaExercicioDto(
        @NotNull(message = "O ID da rotina é obrigatório.") Integer rotinaId,

        @NotNull(message = "O ID do exercício é obrigatório.") Integer exercicioId,

        @NotNull(message = "O número de séries planejadas é obrigatório.")
        @Min(value = 1, message = "O número de séries planejadas deve ser no mínimo 1.") Integer seriesPlanejadas) {
}
