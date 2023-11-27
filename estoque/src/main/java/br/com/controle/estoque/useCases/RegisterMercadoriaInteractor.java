package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.EstoqueMercadoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegisterMercadoriaInteractor {

    private final EstoqueMercadoriaRepository estoqueMercadoriaRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(RegisterMercadoriaInteractor.class);

    public RegisterMercadoriaInteractor(EstoqueMercadoriaRepository estoqueMercadoriaRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueMercadoriaRepository = estoqueMercadoriaRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }


    public MercadoriaDTO registerMercadoria(MercadoriaEntity mercadoria){
        MercadoriaEntity saveMercadoria = estoqueMercadoriaRepository.save(mercadoria);

        logger.info("Mercadoria registrada com sucesso.");
        return mercadoriaEntityMapper.toDTO(saveMercadoria);
    }
}
