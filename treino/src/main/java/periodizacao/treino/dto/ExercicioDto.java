package periodizacao.treino.dto;

import jakarta.validation.constraints.NotBlank;

public record ExercicioDto(@NotBlank(message = "O nome é obrigatório") String nome, Integer usuarioID) {
}
