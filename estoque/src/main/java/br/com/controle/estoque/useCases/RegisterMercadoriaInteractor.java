package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.entity.Mercadoria;
import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.EstoqueRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class RegisterMercadoriaInteractor {

    private EstoqueRepository estoqueRepository;
    private MercadoriaEntityMapper mercadoriaEntityMapper;

    public RegisterMercadoria(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }

    public MercadoriaDTO registerMercadoria (@Valid Mercadoria mercadoria){
        return mercadoriaEntityMapper.convertToDTO(estoqueRepository.save(mercadoria));
    }


}
