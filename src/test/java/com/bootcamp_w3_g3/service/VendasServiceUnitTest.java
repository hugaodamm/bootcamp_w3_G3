package com.bootcamp_w3_g3.service;

import com.bootcamp_w3_g3.model.entity.*;
import com.bootcamp_w3_g3.repository.ProdutoRepository;
import com.bootcamp_w3_g3.repository.VendaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Criado teste unitário referente a classe VendasService - Requisito 6
 * @author Hugo Damm
 */

public class VendasServiceUnitTest {

    private VendaService vendaService;

    private final VendaRepository vendaRepository = Mockito.mock(VendaRepository.class);

    private final ProdutoRepository produtoRepository = Mockito.mock(ProdutoRepository.class);

    private ProdutoService produtoService = Mockito.mock(ProdutoService.class);

    Vendedor vendedor1 = Vendedor.builder()
            .nome("Joaquim")
            .sobrenome("Borges")
            .codigo("V-1")
            .cpf("12312344567")
            .endereco("Rua Estraburgo, 45, São Paulo - BR")
            .build();

    Vendedor vendedor2 = Vendedor.builder()
            .nome("Hugo")
            .sobrenome("Damm")
            .codigo("V-2")
            .cpf("11122233344")
            .endereco("Rua do Rio de Janeiro, 500, Rio de Janeiro - BR")
            .build();

    Produto produto1 = Produto.builder()
            .codigoDoProduto(1)
            .nome("carne")
            .preco(20.0)
            .tipoProduto(TipoProduto.CONGELADOS)
            .build();

    Produto produto2 = Produto.builder()
            .codigoDoProduto(2)
            .nome("carne")
            .preco(120.0)
            .tipoProduto(TipoProduto.CONGELADOS)
            .build();

    Produto produto3 = Produto.builder()
            .codigoDoProduto(3)
            .nome("carne")
            .preco(10.0)
            .tipoProduto(TipoProduto.CONGELADOS)
            .build();

    Produto produto4 = Produto.builder()
            .codigoDoProduto(4)
            .nome("carne")
            .preco(80.0)
            .tipoProduto(TipoProduto.CONGELADOS)
            .build();

    Produto produto5 = Produto.builder()
            .codigoDoProduto(5)
            .nome("carne")
            .preco(30.0)
            .tipoProduto(TipoProduto.CONGELADOS)
            .build();

    Produto produto6 = Produto.builder()
            .codigoDoProduto(6)
            .nome("carne")
            .preco(90.0)
            .tipoProduto(TipoProduto.CONGELADOS)
            .build();

    Venda venda1 = Venda.builder()
            .vendedor(vendedor1)
            .valorTotal(produto1.getPreco())
            .build();

    Venda venda2 = Venda.builder()
            .vendedor(vendedor1)
            .valorTotal(produto2.getPreco())
            .build();

    List<Venda> vendaList = new ArrayList<>();



    /**
     * Teste deve listar as vendas
     */
    @Test
    void listarVendaTest(){
        vendaList.add(venda1);
        vendaList.add(venda2);

        Mockito.when(vendaRepository.findAll()).thenReturn(vendaList);

        vendaService = new VendaService(vendaRepository);
        List<Venda> lista = vendaService.listar();

        Mockito.verify(vendaRepository, Mockito.times(1)).findAll();

        assertEquals(lista.size(),vendaList.size());
    }


}
