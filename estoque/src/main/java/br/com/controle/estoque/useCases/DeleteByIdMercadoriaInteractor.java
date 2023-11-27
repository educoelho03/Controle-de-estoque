package br.com.controle.estoque.useCases;

import br.com.controle.estoque.exception.RecordNotFoundException;
import br.com.controle.estoque.repository.EstoqueMercadoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeleteByIdMercadoriaInteractor {

    private final EstoqueMercadoriaRepository estoqueMercadoriaRepository;
    private static final Logger logger = LoggerFactory.getLogger(FindByIdMercadoriaInteractor.class);


    public DeleteByIdMercadoriaInteractor(EstoqueMercadoriaRepository estoqueMercadoriaRepository) {
        this.estoqueMercadoriaRepository = estoqueMercadoriaRepository;
    }

    public boolean deleteMercadoriaById(Long id) {
        try {
            if (estoqueMercadoriaRepository.findById(id).isPresent()) {
                estoqueMercadoriaRepository.deleteById(id);
                logger.info("Mercadoria removida com sucesso.");
                return true;
            }
        } catch (Exception e) {
            throw new RecordNotFoundException("Record não encontrado. " + id);
        }
        return false;
    }
}
