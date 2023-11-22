package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.exception.RecordNotFoundException;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class FindByIdMercadoriaInteractor {

    private final EstoqueRepository estoqueRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;

    public FindByIdMercadoriaInteractor(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }

//    public ResponseEntity<MercadoriaDTO> findMercadoriaById(@PathVariable Long id){
//        try {
//            return ResponseEntity.ok(estoqueRepository.findById(id)
//                    .map(mercadoriaEntityMapper::toDTO)
//                    .orElseThrow(() -> new RecordNotFoundException("Record nao encontrado. " + id)));
//        } catch (RecordNotFoundException e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }


    public MercadoriaDTO findMercadoriaById(Long id){

        MercadoriaDTO mercadoriaDTO = estoqueRepository.findById(id).map(mercadoriaEntityMapper::toDTO)
                    .orElseThrow( () -> new RecordNotFoundException("Record nao encontrado. " + id));
        return mercadoriaDTO;
    }
}
