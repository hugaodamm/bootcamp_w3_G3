package com.bootcamp_w3_g3.model.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@ApiModel(description = "Classe representando a Venda rastreado pelo aplicativo.")
public class Venda {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Vendedor vendedor;
    private Double valorTotal;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos;


}
