package br.ucsal.youp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrilhaCarreira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @OneToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    private String nome;
    private boolean status;

}
