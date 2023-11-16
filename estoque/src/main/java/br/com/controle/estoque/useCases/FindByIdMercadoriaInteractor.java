package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.exceptionHandler.RecordNotFoundException;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
// TODO: Preciso usar assinaturas? como SERVICE, REPOSITORY...
public class FindByIdMercadoriaInteractor {

    private final EstoqueRepository estoqueRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;

    public FindByIdMercadoriaInteractor(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }

    public MercadoriaDTO findMercadoriaById(@PathVariable Long id) throws RecordNotFoundException {
        return estoqueRepository.findById(id).map(mercadoriaEntityMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }
}
