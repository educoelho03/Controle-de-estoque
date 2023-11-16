package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.entity.MercadoriaEntity;
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

    public MercadoriaDTO update(Long id, MercadoriaEntity mercadoriaEntity) throws RecordNotFoundException {
        return estoqueRepository.findById(id).map(
                recordFound -> {
                    recordFound.setName(mercadoriaEntity.getName());
                    recordFound.setDescription(mercadoriaEntity.getDescription());
                    recordFound.setType(mercadoriaEntity.getType());
                    return estoqueRepository.save(recordFound);
                }).map(mercadoriaEntityMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }
}
