package br.ucsal.youp.repository;

import br.ucsal.youp.model.Funcionario;
import br.ucsal.youp.model.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {

    List<Habilidade> findByNome(String nome);
}
