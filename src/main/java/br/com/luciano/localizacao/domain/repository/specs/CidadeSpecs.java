package br.com.luciano.localizacao.domain.repository.specs;

import br.com.luciano.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public class CidadeSpecs {

   public static Specification<Cidade> nomeEqual(String nome){
       return (root, query, cb) -> cb.equal(root.get("nome"), nome);
   }

   public static Specification<Cidade> nomeLike(String nome){
        StringBuilder nomeUpperCase = new StringBuilder();
        nomeUpperCase.append("%")
                .append(nome.toUpperCase())
                .append("%");
         System.out.println(nomeUpperCase);
        return (root, query, cb) -> cb.like(cb.upper(root.get("nome")),nomeUpperCase.toString() );
   }

    public static Specification<Cidade> habitantesGreaterThan(Long habitantes){
        return (root, query, cb) -> cb.greaterThan(root.get("habitantes"), habitantes);
    }

    public static Specification<Cidade> habitantesGreaterThanNomeLike(Long habitantes){
        return (root, query, cb) -> cb.greaterThan(root.get("habitantes"), habitantes);
    }

}
