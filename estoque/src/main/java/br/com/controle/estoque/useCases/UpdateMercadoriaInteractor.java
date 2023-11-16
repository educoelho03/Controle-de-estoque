package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.entity.Mercadoria;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.exceptionHandler.RecordNotFoundException;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateMercadoriaInteractor {

    private final EstoqueRepository estoqueRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;

    public UpdateMercadoriaInteractor(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }

    public MercadoriaDTO update(Long id, Mercadoria mercadoria) throws RecordNotFoundException {
        return estoqueRepository.findById(id).map(
                recordFound -> {
                    recordFound.setName(mercadoria.getName());
                    recordFound.setDescription(mercadoria.getDescription());
                    recordFound.setInOut(mercadoria.getInOut());
                    return estoqueRepository.save(recordFound);
                }).map(mercadoriaEntityMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }
}
