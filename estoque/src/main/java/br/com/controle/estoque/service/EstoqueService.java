package br.com.controle.estoque.service;

import br.com.controle.estoque.exceptionHandler.RecordNotFoundException;
import br.com.controle.estoque.model.Mercadoria;
import br.com.controle.estoque.model.dto.MercadoriaDTO;
import br.com.controle.estoque.model.dto.mapper.MercadoriaMapper;
import br.com.controle.estoque.repository.EstoqueRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private final MercadoriaMapper mercadoriaMapper;

    public EstoqueService(EstoqueRepository estoqueRepository, MercadoriaMapper mercadoriaMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaMapper = mercadoriaMapper;
    }

    public List<MercadoriaDTO> findAll(){
        return estoqueRepository.findAll()
                .stream()
                .map(mercadoriaMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    public MercadoriaDTO createMercadoria (@Valid Mercadoria mercadoria){
        return mercadoriaMapper.convertToDTO(estoqueRepository.save(mercadoria));
    }

    public MercadoriaDTO findMercadoriaById(@PathVariable Long id) throws RecordNotFoundException {
        return estoqueRepository.findById(id).map(mercadoriaMapper::convertToDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public MercadoriaDTO update(Long id, Mercadoria mercadoria) throws RecordNotFoundException {
        return estoqueRepository.findById(id).map(
                recordFound -> {
                    recordFound.setName(mercadoria.getName());
                    recordFound.setDescription(mercadoria.getDescription());
                    recordFound.setInOut(mercadoria.getInOut());
                    return estoqueRepository.save(recordFound);
                }).map(mercadoriaMapper::convertToDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }

}
