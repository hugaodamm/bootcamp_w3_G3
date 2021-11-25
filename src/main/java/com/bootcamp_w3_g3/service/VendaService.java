package com.bootcamp_w3_g3.service;

import com.bootcamp_w3_g3.model.entity.Produto;
import com.bootcamp_w3_g3.model.entity.Venda;
import com.bootcamp_w3_g3.model.entity.Vendedor;
import com.bootcamp_w3_g3.repository.VendaRepository;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
public class VendaService {

    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private VendedorService vendedorService;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Transactional
    public Venda registrar(Venda venda) {
        //aqui ele vai receber todos os produtos, somar os precos e armazenar na variavel
        double precoTotal = precoTotal(venda.getProdutos());
        // aqui ele esta setando o valor total na venda para salvar
        venda.setValorTotal(precoTotal);
        // aqui vai buscar o vendedor para setor o valor da venda realizada por ele.
        Vendedor vendedor = vendedorService.obter(venda.getVendedor().getCodigo());
        //aqui esta adicionando o valor da venda atual e somando com o que existe em cada vendedor
        adicionaValorDaVenda(precoTotal, vendedor);

        return vendaRepository.save(venda);
    }

    public List<Venda> listar(){
        return vendaRepository.findAll();
    }

    public int totalDeVendas(String codigoVendedor) {
        int totalVendas = 0;
        for (Venda venda : listar()) {
            if (venda.getVendedor().getCodigo().equals(codigoVendedor)){
                totalVendas ++;
            }
        }
        return totalVendas;
    }


    public List<Vendedor> relatorioDeVendas(){
        List<Vendedor> listaVendedor = vendedorService.listar();
        listaVendedor.sort((vendedor1, vendedor2) -> vendedor1.getTotalVendas().compareTo(vendedor2.getTotalVendas()));

        return listaVendedor;
    }

    /**
     *Metodos auxiliar para somar o valor total
     * dos produtos venddidos.
     */
    private Double precoTotal(List<Produto> produtos) {
        double preco = 0;
        for (Produto p : produtos) {
            preco += p.getPreco();
        }
        return preco;
    }

    //incrementa valor total da compra ao registro do vendedor
    // metodo auxiliar
    private void adicionaValorDaVenda(double precoTotal, Vendedor vendedor) {

        double atual = vendedor.getTotalVendas() + precoTotal;
        vendedor.setTotalVendas(atual);

        vendedorService.atualizar(vendedor);
    }

}
