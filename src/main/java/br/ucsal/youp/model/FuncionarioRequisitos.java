package br.ucsal.youp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "funcionario_requisitos")
@Data
public class FuncionarioRequisitos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Funcionario funcionario;

    @Column(name = "requisitos")
    private String requisito;
}
