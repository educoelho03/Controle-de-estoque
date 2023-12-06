package br.com.controle.estoque.useCases.mercadoriaImp;

import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.MercadoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegisterMercadoriaInteractor {

    private final MercadoriaRepository mercadoriaRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(RegisterMercadoriaInteractor.class);

    public RegisterMercadoriaInteractor(MercadoriaRepository mercadoriaRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.mercadoriaRepository = mercadoriaRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }


    public MercadoriaDTO registerMercadoria(MercadoriaEntity mercadoria){
        MercadoriaEntity saveMercadoria = mercadoriaRepository.save(mercadoria);

        logger.info("Mercadoria registrada com sucesso.");
        return mercadoriaEntityMapper.toDTO(saveMercadoria);
    }
}
