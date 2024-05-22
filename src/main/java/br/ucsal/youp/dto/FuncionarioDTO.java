package br.ucsal.youp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record FuncionarioDTO(Long id, @NotEmpty String nome, @NotEmpty String email, @NotEmpty String senha,
                             @NotEmpty String cargoAtual, @NotEmpty String cargoFuturo, @NotEmpty String experiencia,
                             @NotEmpty String habilidades, @NotEmpty String objetivoCarreira) {
}
