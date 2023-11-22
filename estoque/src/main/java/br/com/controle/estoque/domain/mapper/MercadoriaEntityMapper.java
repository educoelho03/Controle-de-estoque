package br.com.controle.estoque.domain.mapper;

import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import org.springframework.stereotype.Component;

@Component
// TODO: USAR A DEPENDENCIA MODELMAPPER?
public class MercadoriaEntityMapper {

    // TODO: Conferir uso do Builder
    public MercadoriaEntity ToEntity(MercadoriaDTO mercadoriaDTO){
        return new MercadoriaEntity.Builder()
                .name(mercadoriaDTO.name())
                .date(mercadoriaDTO.date())
                .price(mercadoriaDTO.price())
                .amount(mercadoriaDTO.amount())
                .total(mercadoriaDTO.total())
                .type(mercadoriaDTO.type())
                .description(mercadoriaDTO.description()).build();
    }

    public MercadoriaDTO toDTO(MercadoriaEntity mercadoriaEntity){
        return new MercadoriaDTO(
                mercadoriaEntity.getName(),
                mercadoriaEntity.getDate(),
                mercadoriaEntity.getDescription(),
                mercadoriaEntity.getPrice(),
                mercadoriaEntity.getAmount(),
                mercadoriaEntity.getTotal(),
                mercadoriaEntity.getType());
    }
}
