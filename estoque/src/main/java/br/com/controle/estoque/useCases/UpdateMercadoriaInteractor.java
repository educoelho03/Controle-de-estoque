package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.exceptionHandler.RecordNotFoundException;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateMercadoriaInteractor {

    private final EstoqueRepository estoqueRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;

    public UpdateMercadoriaInteractor(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }

    public ResponseEntity<MercadoriaDTO> update(Long id, MercadoriaEntity mercadoria) {
        return estoqueRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(mercadoria.getName());
                    recordFound.setDescription(mercadoria.getDescription());
                    recordFound.setType(mercadoria.getType());
                    estoqueRepository.save(recordFound);
                    MercadoriaDTO updatedMercadoriaDTO = mercadoriaEntityMapper.toDTO(recordFound);
                    return ResponseEntity.ok(updatedMercadoriaDTO);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
