package br.com.controle.estoque.useCases.fornecedorImp;

import br.com.controle.estoque.domain.dto.FornecedorDTO;
import br.com.controle.estoque.domain.entity.FornecedorEntity;
import br.com.controle.estoque.domain.mapper.FornecedorEntityMapper;
import br.com.controle.estoque.repository.FornecedorRepository;
import br.com.controle.estoque.useCases.mercadoriaImp.FindAllMercadoriaInteractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegisterFornecedorInteractor {

    private final FornecedorEntityMapper fornecedorEntityMapper;
    private final FornecedorRepository fornecedorRepository;
    private static final Logger logger = LoggerFactory.getLogger(FindAllMercadoriaInteractor.class);


    public RegisterFornecedorInteractor(FornecedorEntityMapper fornecedorEntityMapper, FornecedorRepository fornecedorRepository) {
        this.fornecedorEntityMapper = fornecedorEntityMapper;
        this.fornecedorRepository = fornecedorRepository;
    }


    public FornecedorDTO registerFornecedor(FornecedorEntity fornecedor){
        FornecedorEntity fornecedorSave = fornecedorRepository.save(fornecedor);
        logger.info("Fornecedor registrado com sucesso.");
        return fornecedorEntityMapper.toDTO(fornecedorSave);
    }

}
