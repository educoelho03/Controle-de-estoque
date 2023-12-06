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
                .withName(mercadoriaDTO.name())
                .withDate(mercadoriaDTO.date())
                .withPrice(mercadoriaDTO.price())
                .withAmount(mercadoriaDTO.amount())
                .withType(mercadoriaDTO.type())
                .withDescription(mercadoriaDTO.description()).build();
    }

    public MercadoriaDTO toDTO(MercadoriaEntity mercadoriaEntity){
        return new MercadoriaDTO(
                mercadoriaEntity.getName(),
                mercadoriaEntity.getDate(),
                mercadoriaEntity.getDescription(),
                mercadoriaEntity.getPrice(),
                mercadoriaEntity.getAmount(),
                mercadoriaEntity.getPriceTotal(),
                mercadoriaEntity.getType());
    }
}
