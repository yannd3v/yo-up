package br.ucsal.youp.repository;

import br.ucsal.youp.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByNome(String nome);
    Funcionario findByEmailAndSenha(String email, String senha);




}
