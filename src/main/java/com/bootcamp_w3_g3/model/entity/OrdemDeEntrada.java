package com.bootcamp_w3_g3.model.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 *
 * @autor Alex Cruz
 */

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "Classe representando a Ordem de Entrada rastreado pelo aplicativo.")
public class OrdemDeEntrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeroDaOrdem;
    private Integer quantidade;
    private LocalDate dataDaOrdem;
    @ManyToOne
    private Setor setor;
    @ManyToOne
    private Representante representante;
    @OneToOne(cascade = CascadeType.ALL)
    private Lote lote;
    @OneToOne
    private Vendedor vendedor;

}
