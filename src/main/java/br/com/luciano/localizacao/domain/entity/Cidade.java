package br.com.luciano.localizacao.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_CIDADE")
public class Cidade {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", length = 50)
    private String nome;

    @Column(name = "QTD_HABITANTES")
    private Long habitantes;
}
