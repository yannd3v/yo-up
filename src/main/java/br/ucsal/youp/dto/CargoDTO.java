package br.ucsal.youp.dto;

import br.ucsal.youp.model.Habilidade;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CargoDTO(@NotEmpty String nome, List<Habilidade> habilidades) {
}
