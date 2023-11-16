package br.com.controle.estoque.domain.mapper;

import br.com.controle.estoque.domain.entity.Mercadoria;
import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import org.springframework.stereotype.Component;

@Component
// TODO: USAR A DEPENDENCIA MODELMAPPER?
public class MercadoriaEntityMapper {

    public Mercadoria ToEntity(MercadoriaDTO mercadoriaDTO){
        return new Mercadoria(
                mercadoriaDTO.name(),
                mercadoriaDTO.description(),
                mercadoriaDTO.amount(),
                mercadoriaDTO.type(),
                mercadoriaDTO.stockPrice()
        );

    }

    public MercadoriaDTO toDTO(Mercadoria mercadoria){
        return new MercadoriaDTO(
                mercadoria.getName(),
                mercadoria.getDescription(),
                mercadoria.getAmount(),
                mercadoria.getInOut(),
                mercadoria.getStockPrice()
        );
    }
}
