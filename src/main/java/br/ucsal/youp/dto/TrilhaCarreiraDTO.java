package br.ucsal.youp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record TrilhaCarreiraDTO(Long id, @NotEmpty String cargoAtual, @NotEmpty String cargoFuturo,
                                @NotEmpty String objetivoCarreira, Long funcionario_id) {
}
