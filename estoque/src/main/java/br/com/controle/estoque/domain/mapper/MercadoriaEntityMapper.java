package br.com.controle.estoque.domain.mapper;

import br.com.controle.estoque.domain.entity.Mercadoria;
import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import org.springframework.stereotype.Component;

@Component
// TODO: USAR A DEPENDENCIA MODELMAPPER?
public class MercadoriaEntityMapper {

    public MercadoriaDTO convertToDTO(Mercadoria mercadoria){
        return new MercadoriaDTO(
                mercadoria.getName(),
                mercadoria.getDescription(),
                mercadoria.getAmount(),
                mercadoria.getInOut(),
                mercadoria.getStockPrice());
    }

    public Mercadoria convertToEntity(MercadoriaDTO mercadoriaDTO){
        if(mercadoriaDTO == null){
            return null;
        }

        Mercadoria mercadoria = new Mercadoria();

        mercadoria.setName(mercadoriaDTO.getName());
        mercadoria.setDescription(mercadoriaDTO.getDescription());
        mercadoria.setAmount(mercadoria.getAmount());
        mercadoria.setInOut(mercadoria.getInOut());

        return mercadoria;

    }
}
