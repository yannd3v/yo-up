package br.ucsal.youp.repository;

import br.ucsal.youp.model.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GestorRepository extends JpaRepository<Gestor, Long> {
    List<Gestor> findByNome(String nome);
}
