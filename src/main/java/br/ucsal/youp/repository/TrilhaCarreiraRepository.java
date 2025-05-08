package br.ucsal.youp.repository;

import br.ucsal.youp.model.TrilhaCarreira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrilhaCarreiraRepository extends JpaRepository<TrilhaCarreira, Long> {
}
