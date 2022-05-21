package br.com.luciano.localizacao.service;

import br.com.luciano.localizacao.domain.entity.Cidade;
import br.com.luciano.localizacao.domain.repository.CidadeRepository;
import br.com.luciano.localizacao.domain.repository.specs.CidadeSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
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

    public List<Cidade> nomeEqual(String nome){
        Specification<Cidade> specs = CidadeSpecs.nomeEqual(nome);
        return this.repository.findAll(specs);
    }

    public List<Cidade> nomeLike(String nome){
        Specification<Cidade> specs = CidadeSpecs.nomeLike(nome);
        return repository.findAll(specs);
    }

/*
    public List<Cidade> habitantesGreaterThanOrNomeLike(String nome, Long habitantes){
        Specification<Cidade> specs = CidadeSpecs.nomeLike(nome).or(CidadeSpecs.habitantesGreaterThan(habitantes));
        return repository.findAll(specs);
    }

 */



    public List<Cidade> habitantesGreaterThanOrNomeLike(Cidade cidade){
        Specification<Cidade> specs = Specification.where((root, query, cb) -> cb.conjunction());

        if(cidade.getNome() != null && !cidade.getNome().isEmpty()){
            specs = specs.and(CidadeSpecs.nomeLike(cidade.getNome()));
        }

        if(cidade.getHabitantes() != null){
            specs = specs.or(CidadeSpecs.habitantesGreaterThan(cidade.getHabitantes()));
        }

        return  repository.findAll(specs);
    }

}
