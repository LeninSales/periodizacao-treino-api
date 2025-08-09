package periodizacao.treino.dto;


import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(@NotBlank(message = "O nome é obrigatório") String nome) {
}
