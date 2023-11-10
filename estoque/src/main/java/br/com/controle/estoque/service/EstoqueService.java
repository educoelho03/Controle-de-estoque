package br.com.controle.estoque.service;

import br.com.controle.estoque.model.Mercadoria;
import br.com.controle.estoque.model.dto.MercadoriaDTO;
import br.com.controle.estoque.model.mapper.MercadoriaMapper;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        return estoqueRepository.findAll().stream().map(mercadoriaMapper::convertToDTO).collect(Collectors.toList());
    }

    public MercadoriaDTO registerMercadoria(Mercadoria mercadoria){
        return mercadoriaMapper.convertToDTO(estoqueRepository.save(mercadoria));
    }


    // todo: Adicionar uma exception personalizada para o Record, "RecordNotFoundException"
    public MercadoriaDTO findMercadoriaById(Long id){
        return estoqueRepository.findById(id).map(mercadoriaMapper::convertToDTO).orElseThrow(RuntimeException::new);
    }

}
