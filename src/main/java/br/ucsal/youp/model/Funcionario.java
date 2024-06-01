package br.ucsal.youp.model;

import jakarta.persistence.*;
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
    private String experiencia;
    @NotEmpty
    private String habilidades;

    @OneToOne
    private PlanoCarreira planoCarreira;



}
