package br.com.controle.estoque.useCases;

import br.com.controle.estoque.exception.RecordNotFoundException;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeleteByIdMercadoriaInteractor {

    private final EstoqueRepository estoqueRepository;
    private static final Logger logger = LoggerFactory.getLogger(FindByIdMercadoriaInteractor.class);


    public DeleteByIdMercadoriaInteractor(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public boolean deleteMercadoriaById(Long id) {
        try {
            if (estoqueRepository.findById(id).isPresent()) {
                estoqueRepository.deleteById(id);
                logger.info("Mercadoria removida com sucesso.");
                return true;
            }
        } catch (Exception e) {
            throw new RecordNotFoundException("Record não encontrado. " + id);
        }
        return false;
    }
}
