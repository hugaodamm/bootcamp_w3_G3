package com.bootcamp_w3_g3.service;

import com.bootcamp_w3_g3.model.entity.Itens;
import com.bootcamp_w3_g3.model.entity.Produto;
import com.bootcamp_w3_g3.model.entity.Vendedor;
import com.bootcamp_w3_g3.repository.ItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Alex Cruz
 */

@Service
public class ItensService {

    private ItensRepository itensRepository;

    private VendedorService vendedorService;
    @Autowired
    public ItensService(ItensRepository itensRepository){
        this.itensRepository = itensRepository;
    }

    @Transactional
    public Itens salvar(Itens itens) {
//        Vendedor vendedor = vendedorService.obter(itens.getProduto().getCodigoVendedor());
//        vendedor.setCodigo(itens.getProduto().getCodigoVendedor());
//        vendedorService.atualizar(vendedor);

        return itensRepository.save(itens);
    }

    public List<Itens> listar() {
        return itensRepository.findAll();
    }

}
