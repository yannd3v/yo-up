package br.ucsal.youp.repository;

import br.ucsal.youp.model.PlanoCarreira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoCarreiraRepository extends JpaRepository<PlanoCarreira, Long> {
}
