package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.entity.MercadoriaEntity;
import br.com.controle.estoque.domain.dto.MercadoriaDTO;
import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.EstoqueRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegisterMercadoriaInteractor {

    private final EstoqueRepository estoqueRepository;
    private final MercadoriaEntityMapper mercadoriaEntityMapper;

    public RegisterMercadoriaInteractor(EstoqueRepository estoqueRepository, MercadoriaEntityMapper mercadoriaEntityMapper) {
        this.estoqueRepository = estoqueRepository;
        this.mercadoriaEntityMapper = mercadoriaEntityMapper;
    }


    public MercadoriaDTO registerMercadoria(MercadoriaEntity mercadoria){
        MercadoriaEntity saveMercadoria = estoqueRepository.save(mercadoria);

        return mercadoriaEntityMapper.toDTO(saveMercadoria);
    }
}
