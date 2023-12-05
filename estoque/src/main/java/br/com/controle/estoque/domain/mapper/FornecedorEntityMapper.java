package br.com.controle.estoque.domain.mapper;

import br.com.controle.estoque.domain.dto.FornecedorDTO;
import br.com.controle.estoque.domain.entity.FornecedorEntity;
import org.springframework.stereotype.Component;

@Component
public class FornecedorEntityMapper {

    public FornecedorEntity ToEntity(FornecedorDTO fornecedorDTO){
        return new FornecedorEntity.Builder()
                .withName(fornecedorDTO.name())
                .withStates(fornecedorDTO.estados())
                .withCnpj(fornecedorDTO.cnpj())
                .withtelefone(fornecedorDTO.telefone())
                .build();
    }

    public FornecedorDTO toDTO(FornecedorEntity fornecedorEntity){
        return new FornecedorDTO(
                fornecedorEntity.getName(),
                fornecedorEntity.getEstados(),
                fornecedorEntity.getCnpj(),
                fornecedorEntity.getTelefone());
    }

}
