package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegisterMercadoriaInteractor {

    private final EstoqueRepository estoqueRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(RegisterMercadoriaInteractor.class);

    public RegisterMercadoriaInteractor(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }


    public MercadoriaDTO registerMercadoria(MercadoriaEntity mercadoria){
        MercadoriaEntity saveMercadoria = estoqueRepository.save(mercadoria);

        logger.info("Mercadoria registrada com sucesso.");
        return mercadoriaEntityMapper.toDTO(saveMercadoria);
    }
}
