package com.bootcamp_w3_g3.model.dtos.response;

import com.bootcamp_w3_g3.model.entity.Vendedor;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hugo damm
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendedorDTO {

    private String codigo;
    private String nome;
    private String sobrenome;
    private Double totalVendas;



    public static VendedorDTO converter (Vendedor vendedor){
        return new VendedorDTO(vendedor.getCodigo(), vendedor.getNome(), vendedor.getSobrenome(), vendedor.getTotalVendas());
    }

    public static List<VendedorDTO> converteLista(List<Vendedor> vendedores){
        List<VendedorDTO> vendedorDTOList = new ArrayList<>();
        for (Vendedor vendedor : vendedores){
            vendedorDTOList.add(new VendedorDTO(
                    vendedor.getCodigo(), vendedor.getNome(), vendedor.getSobrenome(), vendedor.getTotalVendas()
            ));
        }
        return vendedorDTOList;
    }
}
