package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.exception.RecordNotFoundException;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FindByIdMercadoriaInteractor {

    private final EstoqueRepository estoqueRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(FindByIdMercadoriaInteractor.class);


    public FindByIdMercadoriaInteractor(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }


    public MercadoriaDTO findMercadoriaById(Long id){
        logger.info("Mercadoria com id " + id + " encontrada com sucesso.");
        return estoqueRepository.findById(id).map(mercadoriaEntityMapper::toDTO)
                    .orElseThrow( () -> new RecordNotFoundException("Record nao encontrado. " + id));
    }
}
