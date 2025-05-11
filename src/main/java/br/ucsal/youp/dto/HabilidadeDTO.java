package br.ucsal.youp.dto;

import jakarta.validation.constraints.NotEmpty;

public record HabilidadeDTO(@NotEmpty String nome, @NotEmpty String tipo, Long cargo_id) {


}
