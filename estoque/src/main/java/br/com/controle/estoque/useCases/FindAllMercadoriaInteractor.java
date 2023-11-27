package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.EstoqueMercadoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: REMOVER RESPONSEENTITY DOS SERVICE/USE CASES

@Service
public class FindAllMercadoriaInteractor {

    private final EstoqueMercadoriaRepository estoqueMercadoriaRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(FindAllMercadoriaInteractor.class);


    public FindAllMercadoriaInteractor(EstoqueMercadoriaRepository estoqueMercadoriaRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueMercadoriaRepository = estoqueMercadoriaRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }


    public List<MercadoriaDTO> findAll(){
        logger.info("Lista de mercadorias em estoque. ");
        return estoqueMercadoriaRepository.findAll()
                .stream()
                .map(mercadoriaEntityMapper::toDTO)
                .toList();
    }
}
