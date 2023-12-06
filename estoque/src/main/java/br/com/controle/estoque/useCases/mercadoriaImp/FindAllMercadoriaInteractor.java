package br.com.controle.estoque.useCases.mercadoriaImp;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.MercadoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllMercadoriaInteractor {

    private final MercadoriaRepository mercadoriaRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(FindAllMercadoriaInteractor.class);


    public FindAllMercadoriaInteractor(MercadoriaRepository mercadoriaRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.mercadoriaRepository = mercadoriaRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }


    public List<MercadoriaDTO> findAll(){
        logger.info("Lista de mercadorias em estoque. ");
        return mercadoriaRepository.findAll()
                .stream()
                .map(mercadoriaEntityMapper::toDTO)
                .toList();
    }
}
