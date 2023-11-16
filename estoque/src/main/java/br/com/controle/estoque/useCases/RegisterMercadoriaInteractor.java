package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.EstoqueRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class RegisterMercadoriaInteractor {

    private EstoqueRepository estoqueRepository;
    private MercadoriaEntityMapper mercadoriaEntityMapper;

    public RegisterMercadoriaInteractor(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }

    public MercadoriaDTO registerMercadoria (@Valid MercadoriaEntity mercadoriaEntity){
        return mercadoriaEntityMapper.toDTO(estoqueRepository.save(mercadoriaEntity));
    }


}
