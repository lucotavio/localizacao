package br.com.luciano.localizacao.service;

import br.com.luciano.localizacao.domain.entity.Cidade;
import br.com.luciano.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public Cidade save(Cidade cidade){
        return repository.save(cidade);
    }

    public Cidade findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public List<Cidade> findByNomeStartingWith(String nome) {
        return repository.findByNomeStartingWith(nome);
    }

    public List<Cidade> findByNomeEndingWith(String nome) {
        return repository.findByNomeEndingWith(nome);
    }

    public List<Cidade> findByHabitantes(Long habitantes) {
        return repository.findByHabitantes(habitantes);
    }

    public List<Cidade> findByHabitantesLessThan(Long habitantes) {
        return repository.findByHabitantesLessThan(habitantes);
    }

    public List<Cidade> findByHabitantesGreaterThan(Long habitantes) {
        return repository.findByHabitantesGreaterThan(habitantes);
    }

    public List<Cidade> findByHabitantesLessThanEqual(Long habitantes) {
        return repository.findByHabitantesLessThanEqual(habitantes);
    }

    public List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome) {

        return repository.findByHabitantesLessThanAndNomeLike(habitantes, nome);
    }

    public List<Cidade> findAll() {
        return repository.findAll();
    }

    public List<Cidade> findByNomeContaining(String nome) {
        return repository.findByNomeContaining(nome);
    }

    public List<Cidade> findByNomeLike(String nome, Sort sort){
        return repository.findByNomeLike(nome, sort);
    }

    public Page<Cidade> findByNomeLike(@Param("nome") String nome, Pageable pageable){
        return repository.findByNomeLike(nome, pageable);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase("nome")
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);

        Example<Cidade> cidadeExample = Example.of(cidade, matcher);
        return repository.findAll(cidadeExample);
    }
}
