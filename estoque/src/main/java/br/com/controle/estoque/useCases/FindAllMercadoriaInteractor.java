package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: REMOVER RESPONSEENTITY DOS SERVICE/USE CASES

@Service
public class FindAllMercadoriaInteractor {

    private final EstoqueRepository estoqueRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(FindAllMercadoriaInteractor.class);


    public FindAllMercadoriaInteractor(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }


    public List<MercadoriaDTO> findAll(){
        logger.info("Lista de mercadorias em estoque. ");
        return estoqueRepository.findAll()
                .stream()
                .map(mercadoriaEntityMapper::toDTO)
                .toList();
    }
}
