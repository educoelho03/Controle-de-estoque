package br.com.controle.estoque.useCases.fornecedorImp;

import br.com.controle.estoque.domain.dto.FornecedorDTO;
import br.com.controle.estoque.domain.mapper.FornecedorEntityMapper;
import br.com.controle.estoque.exception.RecordNotFoundException;
import br.com.controle.estoque.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindFornecedorByIdInteractor {

    private FornecedorRepository fornecedorRepository;
    private FornecedorEntityMapper fornecedorEntityMapper;

    public FindFornecedorByIdInteractor(FornecedorRepository fornecedorRepository, FornecedorEntityMapper fornecedorEntityMapper) {
        this.fornecedorRepository = fornecedorRepository;
        this.fornecedorEntityMapper = fornecedorEntityMapper;
    }

    public FornecedorDTO listaPorId(Long id){
        return fornecedorRepository.findById(id).map(fornecedorEntityMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException("Id nao encontrado. " + id));

    }
}
