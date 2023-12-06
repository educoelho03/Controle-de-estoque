package br.com.controle.estoque.useCases.mercadoriaImp;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.MercadoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UpdateMercadoriaInteractor {

    private final MercadoriaRepository mercadoriaRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(UpdateMercadoriaInteractor.class);


    public UpdateMercadoriaInteractor(MercadoriaRepository mercadoriaRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.mercadoriaRepository = mercadoriaRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }

    public MercadoriaDTO update(Long id, MercadoriaEntity mercadoria) {
        return mercadoriaRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(mercadoria.getName());
                    recordFound.setDescription(mercadoria.getDescription());
                    recordFound.setType(mercadoria.getType());
                    recordFound.setPrice(mercadoria.getPrice());
                    recordFound.setAmount(mercadoria.getAmount());
                    mercadoriaRepository.save(recordFound);
                    logger.info("Mercadoria Atualizada com sucesso, alterações realizadas: " + recordFound);
                    return mercadoriaEntityMapper.toDTO(recordFound);
                })
                .orElseThrow();
    }
}
