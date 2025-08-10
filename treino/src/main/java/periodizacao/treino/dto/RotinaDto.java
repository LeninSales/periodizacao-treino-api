package periodizacao.treino.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import periodizacao.treino.models.DiaSemana;

public record RotinaDto(@NotNull(message = "O ID do usuário não pode ser nulo.")
                        Integer usuarioId,

                        @NotBlank(message = "O nome da rotina não pode estar em branco.")
                        @Size(max = 100, message = "O nome da rotina deve ter no máximo 100 caracteres.")
                        String nome,

                        @NotNull(message = "O dia da semana não pode ser nulo.")
                        DiaSemana diaSemana) {
}
