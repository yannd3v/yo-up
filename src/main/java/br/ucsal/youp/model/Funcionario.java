package br.ucsal.youp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;
    @NotEmpty
    private String email;
    @NotEmpty
    private String senha;
    @NotEmpty
    private String cargoAtual;
    @NotEmpty
    private String cargoFuturo;
    @NotEmpty
    private String experiencia;
    @NotEmpty
    private String habilidades;
    @NotEmpty
    private String objetivoCarreira;

    private String planoCarreira;


}
