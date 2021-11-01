package com.bootcamp_w3_g3.model.dtos.request;

import com.bootcamp_w3_g3.model.entity.Armazem;
import com.bootcamp_w3_g3.model.entity.Representante;
import com.bootcamp_w3_g3.service.RepresentanteService;
import com.bootcamp_w3_g3.service.SetorService;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ArmazemForm {

    private String codArmazem;
    private String nome;
    private String endereco;
    private Integer numero;
    private String uf;
    private RepresentanteForm representanteForm;

    public Armazem converte(RepresentanteService representanteService) {
        Representante representante = representanteService.obter(representanteForm.getCodigo());

        return Armazem.builder()
                .codArmazem(codArmazem)
                .nome(nome)
                .endereco(endereco)
                .uf(uf)
                .representante(representante)
                .build()
        ;
    }



}
