package br.com.controle.estoque.domain.mapper;

import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import org.springframework.stereotype.Component;

@Component
// TODO: USAR A DEPENDENCIA MODELMAPPER?
public class MercadoriaEntityMapper {

    public MercadoriaEntity ToEntity(MercadoriaDTO mercadoriaDTO){
        return new MercadoriaEntity(
                mercadoriaDTO.name(),
                mercadoriaDTO.date(),
                mercadoriaDTO.price(),
                mercadoriaDTO.amount(),
                mercadoriaDTO.total(),
                mercadoriaDTO.type(),
                mercadoriaDTO.description()
        );

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
