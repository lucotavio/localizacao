package br.com.luciano.localizacao;

import br.com.luciano.localizacao.domain.entity.Cidade;
import br.com.luciano.localizacao.domain.repository.CidadeRepository;
import br.com.luciano.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeService service;

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       this.nomeEqual("Belo");
    }

    public void nomeEqual(String nome){
        // service.nomeEqual("São Paulo").forEach(System.out::println);
        //service.nomeLike("Porto").forEach(System.out::println);
        Cidade cidade = Cidade.builder()
                        .nome("")
                                .habitantes(9_000_000L)
                                        .build();
        service.habitantesGreaterThanOrNomeLike(cidade).forEach(System.out::println);
    }
}
