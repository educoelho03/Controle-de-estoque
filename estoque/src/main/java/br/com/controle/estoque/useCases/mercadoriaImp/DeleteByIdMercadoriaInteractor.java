package br.com.controle.estoque.useCases.mercadoriaImp;

import br.com.controle.estoque.exception.RecordNotFoundException;
import br.com.controle.estoque.repository.MercadoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeleteByIdMercadoriaInteractor {

    private final MercadoriaRepository mercadoriaRepository;
    private static final Logger logger = LoggerFactory.getLogger(FindByIdMercadoriaInteractor.class);


    public DeleteByIdMercadoriaInteractor(MercadoriaRepository mercadoriaRepository) {
        this.mercadoriaRepository = mercadoriaRepository;
    }

    public boolean deleteMercadoriaById(Long id) {
        try {
            if (mercadoriaRepository.findById(id).isPresent()) {
                mercadoriaRepository.deleteById(id);
                logger.info("Mercadoria removida com sucesso.");
                return true;
            }
        } catch (Exception e) {
            throw new RecordNotFoundException("Id não encontrado. " + id);
        }
        return false;
    }
}
