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

        Vendedor vendedor = vendedorService.obter(this.codigoVendedor);

        List<Produto> produtosDaVenda = new ArrayList<>();
        for (CodigoProduto codProduto : codigosProdutos) {
            Produto produto = produtoService.obter(codProduto.getCodigo());
            produtosDaVenda.add(produto);
        }

        return Venda.builder()
                .vendedor(vendedor).produtos(produtosDaVenda).build();
    }
}
