package br.com.luciano.localizacao.domain.repository;

import br.com.luciano.localizacao.domain.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor {

    Cidade findByNome(String nome);

    @Query("SELECT c FROM Cidade c WHERE upper(c.nome ) like upper(:nome)")
    List<Cidade> findByNomeLike(@Param("nome") String nome, Sort sort);

    @Query("SELECT c FROM Cidade c WHERE upper(c.nome ) like upper(:nome)")
    Page<Cidade> findByNomeLike(@Param("nome") String nome, Pageable pageable);

    List<Cidade> findByNomeStartingWith(String nome);

    List<Cidade> findByNomeEndingWith(String nome);

    List<Cidade> findByNomeContaining(String nome);

    List<Cidade> findByHabitantes(Long quantidadeHabitantes);

    List<Cidade> findByHabitantesLessThan(Long habitantes);

    List<Cidade> findByHabitantesLessThanEqual(Long habitantes);

    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);

}
