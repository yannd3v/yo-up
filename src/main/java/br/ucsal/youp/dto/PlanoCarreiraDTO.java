package br.ucsal.youp.dto;

import br.ucsal.youp.model.Funcionario;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record PlanoCarreiraDTO(Long id, @NotEmpty String cargoAtual, @NotEmpty String cargoFuturo,
                               @NotEmpty String objetivoCarreira, Long funcionario_id) {
}
