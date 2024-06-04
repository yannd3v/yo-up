package br.ucsal.youp.dto;

import br.ucsal.youp.model.Funcionario;
import br.ucsal.youp.model.PlanoCarreira;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.util.List;

@Builder
public record FuncionarioDTO(Long id, @NotEmpty String nome, @NotEmpty String email, @NotEmpty String senha,
                             String experiencia,
                             String habilidades) {
}
