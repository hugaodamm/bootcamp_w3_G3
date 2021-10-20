package com.bootcamp_w3_g3.model.dtos.request;

import com.bootcamp_w3_g3.model.entity.Representante;
import lombok.Getter;

/**
 * Criado para recceber payload com as informacõesmm do representante.
 *
 *
 * @Autor Alex Cruz
 */
@Getter
public class RepresentanteForm {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String endereco;

    public RepresentanteForm() {
    }

    public RepresentanteForm(String nome, String sobrenome, String cpf, String telefone, String endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    /**
     * Método criado sem reccebimento sem parametro, e retornando apenas um nono Representante.
     *
     * @return representante
     */
    public Representante converte(){
        return new Representante(nome, sobrenome, cpf, telefone,endereco);
    }

}