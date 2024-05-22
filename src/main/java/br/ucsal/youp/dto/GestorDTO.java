package br.ucsal.youp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record GestorDTO(Long id, @NotEmpty String nome, @NotEmpty String email, @NotEmpty String senha) {


}
