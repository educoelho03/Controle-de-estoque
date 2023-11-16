package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindAllMercadoriaInteractor {

    private EstoqueRepository estoqueRepository;
    private MercadoriaEntityMapper mercadoriaEntityMapper;

    public FindAllMercadoriaInteractor(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }


    public List<MercadoriaDTO> findAll(){
        return estoqueRepository.findAll()
                .stream()
                .map(mercadoriaEntityMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
