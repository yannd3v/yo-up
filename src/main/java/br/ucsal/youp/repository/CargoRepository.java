package br.ucsal.youp.repository;

import br.ucsal.youp.model.Cargo;
import br.ucsal.youp.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

    List<Cargo> findByNome(String nome);

}
