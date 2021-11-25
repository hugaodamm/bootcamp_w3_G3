package com.bootcamp_w3_g3.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
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
