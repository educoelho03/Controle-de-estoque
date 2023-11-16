package br.com.controle.estoque.useCases;

import br.com.controle.estoque.domain.mapper.MercadoriaEntityMapper;
import br.com.controle.estoque.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteByIdMercadoriaInteractor {

    private final EstoqueRepository estoqueRepository;

    public DeleteByIdMercadoriaInteractor(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public boolean deleteMercadoriaById(Long id){
        try {
            if(estoqueRepository.findById(id).isPresent()){
                estoqueRepository.deleteById(id);
                return true;
            }
        } catch (Exception e){
            throw new IllegalArgumentException(e);
        }
        return false;
    }

}
