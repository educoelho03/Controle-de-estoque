package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: REMOVER RESPONSEENTITY DOS SERVICE/USE CASES

@Service
public class FindAllMercadoriaInteractor {

    private final EstoqueRepository estoqueRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;

    public FindAllMercadoriaInteractor(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }


    public List<MercadoriaDTO> findAll(){

        return estoqueRepository.findAll()
                .stream()
                .map(mercadoriaEntityMapper::toDTO)
                .toList();
    }
}
