package com.bootcamp_w3_g3.model.dtos.response;

import com.bootcamp_w3_g3.model.entity.Venda;
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
public class VendaDTO {

    private String codigoVendedor;
    private Double precoTotal;


    public static VendaDTO converter(Venda venda) {
        return VendaDTO.builder()
                .codigoVendedor(venda.getVendedor().getCodigo())
                .precoTotal(venda.getValorTotal()).build();
    }

    public static List<VendaDTO> converteLista(List<Venda> vendas) {
        List<VendaDTO> vendaDTOList = new ArrayList<>();
        for (Venda venda: vendas){
            vendaDTOList.add(new VendaDTO(venda.getVendedor().getCodigo(), venda.getValorTotal()));
        }
        return vendaDTOList;
    }
}
