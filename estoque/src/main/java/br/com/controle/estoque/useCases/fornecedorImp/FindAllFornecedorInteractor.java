package br.com.controle.estoque.useCases.fornecedorImp;


import br.com.controle.estoque.domain.dto.FornecedorDTO;
import br.com.controle.estoque.domain.mapper.FornecedorEntityMapper;
import br.com.controle.estoque.repository.FornecedorRepository;
import br.com.controle.estoque.useCases.mercadoriaImp.FindAllMercadoriaInteractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllFornecedorInteractor {

    private final FornecedorRepository fornecedorRepository;
    private final FornecedorEntityMapper fornecedorEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(FindAllFornecedorInteractor.class);


    public FindAllFornecedorInteractor(FornecedorRepository fornecedorRepository, FornecedorEntityMapper fornecedorEntityMapper) {
        this.fornecedorRepository = fornecedorRepository;
        this.fornecedorEntityMapper = fornecedorEntityMapper;
    }

    public List<FornecedorDTO> listar(){
        logger.info("Lista de Fornecedores. ");
        return fornecedorRepository.findAll()
                .stream()
                .map(fornecedorEntityMapper::toDTO).toList();
    }

}
