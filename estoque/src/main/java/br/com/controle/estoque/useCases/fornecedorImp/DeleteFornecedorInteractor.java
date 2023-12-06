package br.com.controle.estoque.useCases.fornecedorImp;

import br.com.controle.estoque.domain.dto.FornecedorDTO;
import br.com.controle.estoque.domain.mapper.FornecedorEntityMapper;
import br.com.controle.estoque.exception.RecordNotFoundException;
import br.com.controle.estoque.repository.FornecedorRepository;
import br.com.controle.estoque.useCases.mercadoriaImp.FindByIdMercadoriaInteractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeleteFornecedorInteractor {

    private FornecedorRepository fornecedorRepository;
    private static final Logger logger = LoggerFactory.getLogger(FindByIdMercadoriaInteractor.class);


    public DeleteFornecedorInteractor(FornecedorRepository fornecedorRepository, FornecedorEntityMapper fornecedorEntityMapper) {
        this.fornecedorRepository = fornecedorRepository;
    }


    public boolean remover(Long id){
        try {
            if (fornecedorRepository.findById(id).isPresent()) {
                fornecedorRepository.deleteById(id);
                logger.info("Fornecedor removido com sucesso.");
                return true;
            }
        } catch (Exception e) {
            throw new RecordNotFoundException("Id não encontrado. " + id);
        }
        return false;
    }
}
