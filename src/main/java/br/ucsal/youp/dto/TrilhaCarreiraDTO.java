package br.ucsal.youp.dto;

import br.ucsal.youp.model.Habilidade;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.util.List;

@Builder
public record TrilhaCarreiraDTO(Long id, @NotEmpty String nome, @NotEmpty List<Habilidade> habilidades,
                                Long cargo_id, Long funcionario_id, Boolean status) {
}
