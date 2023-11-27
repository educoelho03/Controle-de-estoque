package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.EstoqueMercadoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UpdateMercadoriaInteractor {

    private final EstoqueMercadoriaRepository estoqueMercadoriaRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(UpdateMercadoriaInteractor.class);


    public UpdateMercadoriaInteractor(EstoqueMercadoriaRepository estoqueMercadoriaRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueMercadoriaRepository = estoqueMercadoriaRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }

    public MercadoriaDTO update(Long id, MercadoriaEntity mercadoria) {
        return estoqueMercadoriaRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(mercadoria.getName());
                    recordFound.setDescription(mercadoria.getDescription());
                    recordFound.setType(mercadoria.getType());
                    recordFound.setPrice(mercadoria.getPrice());
                    recordFound.setAmount(mercadoria.getAmount());
                    estoqueMercadoriaRepository.save(recordFound);
                    logger.info("Mercadoria Atualizada com sucesso, alterações realizadas: " + recordFound);
                    return mercadoriaEntityMapper.toDTO(recordFound);
                })
                .orElseThrow();
    }
}
