package br.ucsal.youp.dto;


import br.ucsal.youp.model.Habilidade;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.util.List;


@Builder
public record FuncionarioDTO(Long id, @NotEmpty String nome, @NotEmpty String email, @NotEmpty String senha,
                             @NotEmpty String experiencia,
                             @NotEmpty List<Habilidade> habilidades) {
}
