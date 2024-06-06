package br.ucsal.youp.repository;

import br.ucsal.youp.model.FuncionarioRequisitos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FuncionarioRequisitosRepository extends JpaRepository<FuncionarioRequisitos, Long> {

    @Query(value = "SELECT requisitos from funcionario_requisitos where funcionario_id = ?1", nativeQuery = true)
    List<String> findFuncionarioRequisitosByFuncionario_id(long funcionario_id);
}
