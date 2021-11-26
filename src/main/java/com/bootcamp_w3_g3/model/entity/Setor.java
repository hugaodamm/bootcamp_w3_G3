package com.bootcamp_w3_g3.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import lombok.*;


import javax.persistence.*;


/**
 * @author hugo damm
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@ApiModel(description = "Classe representando o Setor rastreado pelo aplicativo.")
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nome;
    private TipoProduto tipoProduto;

    private Integer espacoDisponivel = 100;

    @JsonBackReference
    @ManyToOne
    private Armazem armazem;



}