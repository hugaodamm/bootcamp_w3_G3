package com.bootcamp_w3_g3.service;

import com.bootcamp_w3_g3.model.entity.Produto;
import com.bootcamp_w3_g3.model.entity.Venda;
import com.bootcamp_w3_g3.model.entity.Vendedor;
import com.bootcamp_w3_g3.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VendaService {

    private VendaRepository vendaRepository;

    @Autowired
    private VendedorService vendedorService;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @Transactional
    public Venda registrar(Venda venda) {

        double precoTotal = precoTotal(venda.getProdutos());
        venda.setValorTotal(precoTotal);
        Vendedor vendedor = vendedorService.obter(venda.getVendedor().getCodigo());
        adicionaValorDaVenda(precoTotal, vendedor);

        return vendaRepository.save(venda);
    }

    public List<Venda> listar(){
        return vendaRepository.findAll();
    }


    public List<Vendedor> relatorioDeVendas(){
        List<Vendedor> listaVendedor = vendedorService.listar();
        listaVendedor.sort((vendedor1, vendedor2) -> vendedor2.getTotalVendas().compareTo(vendedor1.getTotalVendas()));

        return listaVendedor;
    }

    /**
     * Métodos auxiliar para somar o valor total
     * dos produtos venddidos.
     */
    private Double precoTotal(List<Produto> produtos) {
        double preco = 0;
        for (Produto p : produtos) {
            preco += p.getPreco();
        }
        return preco;
    }

    /**
     * Método auxiliar
     * Incrementa o valor total da compra ao registro do vendedor
     */
    private void adicionaValorDaVenda(double precoTotal, Vendedor vendedor) {

        double atual = vendedor.getTotalVendas() + precoTotal;
        vendedor.setTotalVendas(atual);

        vendedorService.atualizar(vendedor);
    }

}
