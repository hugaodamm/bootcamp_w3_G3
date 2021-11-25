package com.bootcamp_w3_g3.model.dtos.request;

import com.bootcamp_w3_g3.model.entity.Produto;
import com.bootcamp_w3_g3.model.entity.Venda;
import com.bootcamp_w3_g3.model.entity.Vendedor;
import com.bootcamp_w3_g3.service.ProdutoService;
import com.bootcamp_w3_g3.service.VendedorService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaForm {

    private String codigoVendedor;
    private List<CodigoProduto> codigosProdutos;


    public Venda converte(VendedorService vendedorService, ProdutoService produtoService) {
        // aqui ele foi verificar se o vendedor realmente existe
        Vendedor vendedor = vendedorService.obter(this.codigoVendedor);

        //aqui ele vai percorrer a lista de produtos, para ver se ele existe no setor do armazem
        List<Produto> produtosDaVenda = new ArrayList<>();
        for (CodigoProduto codProduto : codigosProdutos) {
            //aqui vai buscar cada produto a partir do codigo recebido e adicionar na lista
            Produto produto = produtoService.obter(codProduto.getCodigo());
            produtosDaVenda.add(produto);
        }

        // nao coloquei o valor total como atributo aqui, porque ele esta sendo contabilizado na service, no momento
        // da persistencia.
        return Venda.builder()
                .vendedor(vendedor).produtos(produtosDaVenda).build();
    }
}
