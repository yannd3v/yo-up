package br.ucsal.youp.dto;

import lombok.Data;

@Data
public class AddHabilidadeRequest {
    private Long idFuncionario;
    private Long idCargo;
    private String nome;
    private String tipo;
}
