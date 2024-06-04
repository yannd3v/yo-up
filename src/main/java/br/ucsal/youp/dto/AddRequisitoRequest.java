package br.ucsal.youp.dto;

import lombok.Data;

@Data
public class AddRequisitoRequest {
    private Long idFuncionario;
    private String descricao;
}
