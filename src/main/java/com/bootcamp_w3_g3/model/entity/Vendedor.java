package com.bootcamp_w3_g3.model.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hugo damm
 */


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@ApiModel(description = "Classe representando o Vendedor rastreado pelo aplicativo.")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String codigo;
    private Double totalVendas = 00.0;


    public Vendedor(String nome, String sobrenome, String cpf, String telefone, String endereco) {

        codigo = geraCodigo(nome, sobrenome);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }


    private String geraCodigo(String nome, String sobrenome)
    {
        return "MLVEND_" + (int)Math.floor(Math.random()*100000);
    }


}
